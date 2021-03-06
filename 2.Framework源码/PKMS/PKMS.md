# PackageManagerService

## 一.概述

PackageManagerService(简称PKMS)，是Android系统中核心服务之一，管理着所有跟package相关的工作，常见的比如安装、卸载应用。 PKMS服务也是通过binder进行通信，IPackageManager.aidl由工具转换后自动生成binder的服务端IPackageManager.Stub和客户端IPackageManager.Stub.Proxy，具体关系如图：

<img src=".\assets\package_manager_service.jpg" width="700" height="400">

- Binder服务端：PackageManagerService继承于IPackageManager.Stub；
- Binder客户端：ApplicationPackageManager(简称APM)的成员变量`mPM`继承于IPackageManager.Stub.Proxy; 本身APM是继承于PackageManager对象。

Android系统启动过程中，一路启动到SystemServer后，便可以启动framework的各大服务，本文将介绍PKMS的启动过程

### PKMS职责
- 负责Android系统中Package的安装、升级、卸载
- 对外提供统一的信息查询功能，其中包括查询系统中匹配某Intent的Activities、BroadCastReceivers或Services等

## 二. PKMS启动过程

![pkms_start](.\assets\pkms_start.png)

### scanPackageLI分析

![scanPackageLI](.\assets\scanPackageLI.png)

 PackageParser定了相当多的内部类，这些内部类的作用就是保存对应的信息。解析AndroidManifest.xml文件得到的信息由Package保存。从该类的成员变量可看出，和Android四大组件相关的信息分别由activites、receivers、providers、services保存。由于一个APK可声明多个组件，因此activites和receivers等均声明为ArrayList


## 三.获取PKMS

![get_pkms](.\assets\get_pkms.png)

## 四.启动过程正涉及到的核心文件

|    文件  |  功能    |
| ---- | ---- |
|/data/data/	|App数据目录|
|/data/user/	|App数据目录|
|/data/app/	|App安装目录|
|/data/system/packages.xml	|所有安装app信息|
|/data/system/packages-stopped.xml	|所有强制停止app信息|
|/data/system/packages.list	|所有安装app信息|

Android系统有很多目录可以存放app，如下所示：


|    目录  |  App类别    |
| ---- | ---- |
|/vendor/overlay	|系统App|
|/system/framework	|系统App|
|/system/priv-app	|系统App|
|/system/app	|系统App|
|/vendor/priv-app	|系统App|
|/vendor/app	|系统App|
|/oem/app	|系统App|
|/data/app	|普通App|
|/data/app-private	|普通App|

## apk安装的方式
- 安装系统APK和预置的APK(第一次开机时安装,没有安装界)
	
	> PackageManagerService的构造中会扫描对应目录下的apk,完成安装 
	
- 网络下载应用安装――通过market应用完成，没有安装界面
	
	> 调用PackageManager的installPackage方法执行安装 
	
- ADB工具安装,没有安装界面

  > /repo/system/core/adb/commandline.cpp中install_app方法,该方法调用pm_command通过send_shell_command方法将数据发送到手机端的adbd守护进程中,adbd在收到PC中Console发来的数据之后启动一个Shell,然后执行pm脚本(pm位于/system/bin目录下).
  >
  > pm脚本通过app_process执行pm.jar包的main函数(\system\framework\pm.jar) 
  > 对应源码: /repo/frameworks/base/cmds/pm/src/com/android/commands/pm/Pm.java

- 第三方应用安装,有安装界面 

### apk 安装流程

1. 将app复制到data/app目录下,扫描并解压安装包,并把dex文件(DVM字节码)保存到dalvik-cache目录,
2. 在data/data目录下创建对应的应用数据目录.
3. 解析apk的AndroidManifest.xml文件
4. 显示快捷方式

![apk_install1](.\assets\apk_install1.png)

![apk_install2](.\assets\apk_install2.png)

### apk卸载流程

![apk_delete](.\assets\apk_delete.png)

## 扩展
### [apk打包过程](https://juejin.cn/post/6844903465555066894)

![apk_dabao](.\assets\apk_dabao.png)

#### aapt阶段
- 使用aapt来打包res资源文件，生成R.java、resources.arsc和res文件（二进制 & 非二进制如res/raw和pic保持原样）
- resources.arsc文件
resources.arsc这个文件记录了所有的应用程序资源目录的信息，包括每一个资源名称、类型、值、ID以及所配置的维度信息。我们可以将这个resources.arsc文件想象成是一个资源索引表，这个资源索引表在给定资源ID和设备配置信息的情况下，能够在应用程序的资源目录中快速地找到最匹配的资源

#### aidl阶段
AIDL （Android Interface Definition Language）， Android接口定义语言，Android提供的IPC （Inter Process Communication，进程间通信）的一种独特实现。
这个阶段处理.aidl文件，生成对应的Java接口文件。

####  Java Compiler阶段
通过Java Compiler编译R.java、Java接口文件、Java源文件，生成.class文件。

#### dex阶段
通过dex命令，将.class文件和第三方库中的.class文件处理生成classes.dex。

####  apkbuilder阶段
将classes.dex、resources.arsc、res文件夹(res/raw资源被原装不动地打包进APK之外，其它的资源都会被编译或者处理)、Other Resources(assets文件夹)、AndroidManifest.xml打包成apk文件。
注意：
res/raw和assets的相同点：
- 两者目录下的文件在打包后会原封不动的保存在apk包中，不会被编译成二进制。
res/raw和assets的不同点：
1. res/raw中的文件会被映射到R.java文件中，访问的时候直接使用资源ID即R.id.filename；assets文件夹下的文件不会被映射到R.java中，访问的时候需要AssetManager类。
2. res/raw不可以有目录结构，而assets则可以有目录结构，也就是assets目录下可以再建立文件夹

#### Jarsigner阶段
对apk进行签名，可以进行Debug和Release 签名。

#### zipalign阶段
release mode 下使用 aipalign进行align，即对签名后的apk进行对齐处理。
Zipalign是一个android平台上整理APK文件的工具，它对apk中未压缩的数据进行4字节对齐，对齐后就可以使用mmap函数读取文件，可以像读取内存一样对普通文件进行操作。如果没有4字节对齐，就必须显式的读取，这样比较缓慢并且会耗费额外的内存。
在 Android SDK 中包含一个名为 “zipalign” 的工具，它能够对打包后的 app 进行优化。 其位于 SDK 的 build-tools 目录下, 例如: D:\Develop\Android\sdk\build-tools\23.0.2\zipalign.exe