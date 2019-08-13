package com.lesson.Return.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IaeArrivalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IaeArrivalExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSendcompanyIsNull() {
            addCriterion("SendCompany is null");
            return (Criteria) this;
        }

        public Criteria andSendcompanyIsNotNull() {
            addCriterion("SendCompany is not null");
            return (Criteria) this;
        }

        public Criteria andSendcompanyEqualTo(String value) {
            addCriterion("SendCompany =", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyNotEqualTo(String value) {
            addCriterion("SendCompany <>", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyGreaterThan(String value) {
            addCriterion("SendCompany >", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyGreaterThanOrEqualTo(String value) {
            addCriterion("SendCompany >=", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyLessThan(String value) {
            addCriterion("SendCompany <", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyLessThanOrEqualTo(String value) {
            addCriterion("SendCompany <=", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyLike(String value) {
            addCriterion("SendCompany like", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyNotLike(String value) {
            addCriterion("SendCompany not like", value, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyIn(List<String> values) {
            addCriterion("SendCompany in", values, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyNotIn(List<String> values) {
            addCriterion("SendCompany not in", values, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyBetween(String value1, String value2) {
            addCriterion("SendCompany between", value1, value2, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andSendcompanyNotBetween(String value1, String value2) {
            addCriterion("SendCompany not between", value1, value2, "sendcompany");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNull() {
            addCriterion("consignee is null");
            return (Criteria) this;
        }

        public Criteria andConsigneeIsNotNull() {
            addCriterion("consignee is not null");
            return (Criteria) this;
        }

        public Criteria andConsigneeEqualTo(String value) {
            addCriterion("consignee =", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotEqualTo(String value) {
            addCriterion("consignee <>", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThan(String value) {
            addCriterion("consignee >", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeGreaterThanOrEqualTo(String value) {
            addCriterion("consignee >=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThan(String value) {
            addCriterion("consignee <", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLessThanOrEqualTo(String value) {
            addCriterion("consignee <=", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeLike(String value) {
            addCriterion("consignee like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotLike(String value) {
            addCriterion("consignee not like", value, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeIn(List<String> values) {
            addCriterion("consignee in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotIn(List<String> values) {
            addCriterion("consignee not in", values, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeBetween(String value1, String value2) {
            addCriterion("consignee between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andConsigneeNotBetween(String value1, String value2) {
            addCriterion("consignee not between", value1, value2, "consignee");
            return (Criteria) this;
        }

        public Criteria andCargoaddressIsNull() {
            addCriterion("CargoAddress is null");
            return (Criteria) this;
        }

        public Criteria andCargoaddressIsNotNull() {
            addCriterion("CargoAddress is not null");
            return (Criteria) this;
        }

        public Criteria andCargoaddressEqualTo(String value) {
            addCriterion("CargoAddress =", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressNotEqualTo(String value) {
            addCriterion("CargoAddress <>", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressGreaterThan(String value) {
            addCriterion("CargoAddress >", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressGreaterThanOrEqualTo(String value) {
            addCriterion("CargoAddress >=", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressLessThan(String value) {
            addCriterion("CargoAddress <", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressLessThanOrEqualTo(String value) {
            addCriterion("CargoAddress <=", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressLike(String value) {
            addCriterion("CargoAddress like", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressNotLike(String value) {
            addCriterion("CargoAddress not like", value, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressIn(List<String> values) {
            addCriterion("CargoAddress in", values, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressNotIn(List<String> values) {
            addCriterion("CargoAddress not in", values, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressBetween(String value1, String value2) {
            addCriterion("CargoAddress between", value1, value2, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andCargoaddressNotBetween(String value1, String value2) {
            addCriterion("CargoAddress not between", value1, value2, "cargoaddress");
            return (Criteria) this;
        }

        public Criteria andIssuepersonIsNull() {
            addCriterion("IssuePerson is null");
            return (Criteria) this;
        }

        public Criteria andIssuepersonIsNotNull() {
            addCriterion("IssuePerson is not null");
            return (Criteria) this;
        }

        public Criteria andIssuepersonEqualTo(String value) {
            addCriterion("IssuePerson =", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotEqualTo(String value) {
            addCriterion("IssuePerson <>", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonGreaterThan(String value) {
            addCriterion("IssuePerson >", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonGreaterThanOrEqualTo(String value) {
            addCriterion("IssuePerson >=", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLessThan(String value) {
            addCriterion("IssuePerson <", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLessThanOrEqualTo(String value) {
            addCriterion("IssuePerson <=", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonLike(String value) {
            addCriterion("IssuePerson like", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotLike(String value) {
            addCriterion("IssuePerson not like", value, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonIn(List<String> values) {
            addCriterion("IssuePerson in", values, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotIn(List<String> values) {
            addCriterion("IssuePerson not in", values, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonBetween(String value1, String value2) {
            addCriterion("IssuePerson between", value1, value2, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuepersonNotBetween(String value1, String value2) {
            addCriterion("IssuePerson not between", value1, value2, "issueperson");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("IssueDate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("IssueDate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterion("IssueDate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterion("IssueDate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterion("IssueDate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterion("IssueDate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterion("IssueDate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterion("IssueDate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterion("IssueDate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterion("IssueDate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterion("IssueDate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterion("IssueDate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIsNull() {
            addCriterion("WorkAddress is null");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIsNotNull() {
            addCriterion("WorkAddress is not null");
            return (Criteria) this;
        }

        public Criteria andWorkaddressEqualTo(String value) {
            addCriterion("WorkAddress =", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotEqualTo(String value) {
            addCriterion("WorkAddress <>", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressGreaterThan(String value) {
            addCriterion("WorkAddress >", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressGreaterThanOrEqualTo(String value) {
            addCriterion("WorkAddress >=", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLessThan(String value) {
            addCriterion("WorkAddress <", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLessThanOrEqualTo(String value) {
            addCriterion("WorkAddress <=", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLike(String value) {
            addCriterion("WorkAddress like", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotLike(String value) {
            addCriterion("WorkAddress not like", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIn(List<String> values) {
            addCriterion("WorkAddress in", values, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotIn(List<String> values) {
            addCriterion("WorkAddress not in", values, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressBetween(String value1, String value2) {
            addCriterion("WorkAddress between", value1, value2, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotBetween(String value1, String value2) {
            addCriterion("WorkAddress not between", value1, value2, "workaddress");
            return (Criteria) this;
        }

        public Criteria andStoragedateIsNull() {
            addCriterion("StorageDate is null");
            return (Criteria) this;
        }

        public Criteria andStoragedateIsNotNull() {
            addCriterion("StorageDate is not null");
            return (Criteria) this;
        }

        public Criteria andStoragedateEqualTo(Date value) {
            addCriterion("StorageDate =", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateNotEqualTo(Date value) {
            addCriterion("StorageDate <>", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateGreaterThan(Date value) {
            addCriterion("StorageDate >", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateGreaterThanOrEqualTo(Date value) {
            addCriterion("StorageDate >=", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateLessThan(Date value) {
            addCriterion("StorageDate <", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateLessThanOrEqualTo(Date value) {
            addCriterion("StorageDate <=", value, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateIn(List<Date> values) {
            addCriterion("StorageDate in", values, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateNotIn(List<Date> values) {
            addCriterion("StorageDate not in", values, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateBetween(Date value1, Date value2) {
            addCriterion("StorageDate between", value1, value2, "storagedate");
            return (Criteria) this;
        }

        public Criteria andStoragedateNotBetween(Date value1, Date value2) {
            addCriterion("StorageDate not between", value1, value2, "storagedate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateIsNull() {
            addCriterion("OutBoundDate is null");
            return (Criteria) this;
        }

        public Criteria andOutbounddateIsNotNull() {
            addCriterion("OutBoundDate is not null");
            return (Criteria) this;
        }

        public Criteria andOutbounddateEqualTo(Date value) {
            addCriterion("OutBoundDate =", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateNotEqualTo(Date value) {
            addCriterion("OutBoundDate <>", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateGreaterThan(Date value) {
            addCriterion("OutBoundDate >", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateGreaterThanOrEqualTo(Date value) {
            addCriterion("OutBoundDate >=", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateLessThan(Date value) {
            addCriterion("OutBoundDate <", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateLessThanOrEqualTo(Date value) {
            addCriterion("OutBoundDate <=", value, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateIn(List<Date> values) {
            addCriterion("OutBoundDate in", values, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateNotIn(List<Date> values) {
            addCriterion("OutBoundDate not in", values, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateBetween(Date value1, Date value2) {
            addCriterion("OutBoundDate between", value1, value2, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andOutbounddateNotBetween(Date value1, Date value2) {
            addCriterion("OutBoundDate not between", value1, value2, "outbounddate");
            return (Criteria) this;
        }

        public Criteria andFailureIsNull() {
            addCriterion("failure is null");
            return (Criteria) this;
        }

        public Criteria andFailureIsNotNull() {
            addCriterion("failure is not null");
            return (Criteria) this;
        }

        public Criteria andFailureEqualTo(String value) {
            addCriterion("failure =", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureNotEqualTo(String value) {
            addCriterion("failure <>", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureGreaterThan(String value) {
            addCriterion("failure >", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureGreaterThanOrEqualTo(String value) {
            addCriterion("failure >=", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureLessThan(String value) {
            addCriterion("failure <", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureLessThanOrEqualTo(String value) {
            addCriterion("failure <=", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureLike(String value) {
            addCriterion("failure like", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureNotLike(String value) {
            addCriterion("failure not like", value, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureIn(List<String> values) {
            addCriterion("failure in", values, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureNotIn(List<String> values) {
            addCriterion("failure not in", values, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureBetween(String value1, String value2) {
            addCriterion("failure between", value1, value2, "failure");
            return (Criteria) this;
        }

        public Criteria andFailureNotBetween(String value1, String value2) {
            addCriterion("failure not between", value1, value2, "failure");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNull() {
            addCriterion("TimeLimit is null");
            return (Criteria) this;
        }

        public Criteria andTimelimitIsNotNull() {
            addCriterion("TimeLimit is not null");
            return (Criteria) this;
        }

        public Criteria andTimelimitEqualTo(Date value) {
            addCriterion("TimeLimit =", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotEqualTo(Date value) {
            addCriterion("TimeLimit <>", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThan(Date value) {
            addCriterion("TimeLimit >", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitGreaterThanOrEqualTo(Date value) {
            addCriterion("TimeLimit >=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThan(Date value) {
            addCriterion("TimeLimit <", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitLessThanOrEqualTo(Date value) {
            addCriterion("TimeLimit <=", value, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitIn(List<Date> values) {
            addCriterion("TimeLimit in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotIn(List<Date> values) {
            addCriterion("TimeLimit not in", values, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitBetween(Date value1, Date value2) {
            addCriterion("TimeLimit between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andTimelimitNotBetween(Date value1, Date value2) {
            addCriterion("TimeLimit not between", value1, value2, "timelimit");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("Batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("Batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("Batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("Batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("Batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("Batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("Batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("Batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("Batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("Batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("Batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("Batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("Batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("Batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIsNull() {
            addCriterion("GoodsState is null");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIsNotNull() {
            addCriterion("GoodsState is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsstateEqualTo(String value) {
            addCriterion("GoodsState =", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotEqualTo(String value) {
            addCriterion("GoodsState <>", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateGreaterThan(String value) {
            addCriterion("GoodsState >", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateGreaterThanOrEqualTo(String value) {
            addCriterion("GoodsState >=", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLessThan(String value) {
            addCriterion("GoodsState <", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLessThanOrEqualTo(String value) {
            addCriterion("GoodsState <=", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateLike(String value) {
            addCriterion("GoodsState like", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotLike(String value) {
            addCriterion("GoodsState not like", value, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateIn(List<String> values) {
            addCriterion("GoodsState in", values, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotIn(List<String> values) {
            addCriterion("GoodsState not in", values, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateBetween(String value1, String value2) {
            addCriterion("GoodsState between", value1, value2, "goodsstate");
            return (Criteria) this;
        }

        public Criteria andGoodsstateNotBetween(String value1, String value2) {
            addCriterion("GoodsState not between", value1, value2, "goodsstate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}