package com.sun.demo22;

/**
 * 职责链模式
 * <p>
 * 1) 职责链模式(ChainofResponsibilityPattern),又叫责任链模式，为请求创建了一个接收者对象的链(简单示意
 * 图)。这种模式对请求的发送者和接收者进行解耦。
 * 2) 职责链模式通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的
 * 请求传给下一个接收者，依此类推。
 * 3) 这种类型的设计模式属于行为型模式
 * <p>
 * <p>
 * 注意细节
 * <p>
 * 1) 将请求和处理分开，实现解耦，提高系统的灵活性
 * 2) 简化了对象，使对象不需要知道链的结构
 * 3) 性能会受到影响，特别是在链比较长的时候，因此需控制链中最大节点数量，一般通过在Handler中设置一个最大节点数量，在 setNext()方法中判断是否已经超过阀值，超过则不允许该链建立，避免出现超长链无意识地 破坏系统性能
 * 4) 调试不方便。采用了类似递归的方式，调试时逻辑可能比较复杂 对 Encoding 的处理、拦截器
 * 5）最佳应用场景：有多个对象可以处理同一个请求时，比如：多级请求、请假、加薪等审批流程
 */

public class MainClass {
    public static void main(String[] args) {

        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
        //创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");
        //需要将各个审批级别的下一个设置好 (处理人构成环形: )
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);
        viceSchoolMasterApprover.processRequest(purchaseRequest);
        schoolMasterApprover.processRequest(purchaseRequest);
    }
}