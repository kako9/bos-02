package com.lesson.dispatch.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisWorkordersignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisWorkordersignExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIsNull() {
            addCriterion("WorkOrderID is null");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIsNotNull() {
            addCriterion("WorkOrderID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkorderidEqualTo(String value) {
            addCriterion("WorkOrderID =", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotEqualTo(String value) {
            addCriterion("WorkOrderID <>", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidGreaterThan(String value) {
            addCriterion("WorkOrderID >", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidGreaterThanOrEqualTo(String value) {
            addCriterion("WorkOrderID >=", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLessThan(String value) {
            addCriterion("WorkOrderID <", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLessThanOrEqualTo(String value) {
            addCriterion("WorkOrderID <=", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidLike(String value) {
            addCriterion("WorkOrderID like", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotLike(String value) {
            addCriterion("WorkOrderID not like", value, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidIn(List<String> values) {
            addCriterion("WorkOrderID in", values, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotIn(List<String> values) {
            addCriterion("WorkOrderID not in", values, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidBetween(String value1, String value2) {
            addCriterion("WorkOrderID between", value1, value2, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorkorderidNotBetween(String value1, String value2) {
            addCriterion("WorkOrderID not between", value1, value2, "workorderid");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoIsNull() {
            addCriterion("WorkSheetNo is null");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoIsNotNull() {
            addCriterion("WorkSheetNo is not null");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoEqualTo(String value) {
            addCriterion("WorkSheetNo =", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoNotEqualTo(String value) {
            addCriterion("WorkSheetNo <>", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoGreaterThan(String value) {
            addCriterion("WorkSheetNo >", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoGreaterThanOrEqualTo(String value) {
            addCriterion("WorkSheetNo >=", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoLessThan(String value) {
            addCriterion("WorkSheetNo <", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoLessThanOrEqualTo(String value) {
            addCriterion("WorkSheetNo <=", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoLike(String value) {
            addCriterion("WorkSheetNo like", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoNotLike(String value) {
            addCriterion("WorkSheetNo not like", value, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoIn(List<String> values) {
            addCriterion("WorkSheetNo in", values, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoNotIn(List<String> values) {
            addCriterion("WorkSheetNo not in", values, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoBetween(String value1, String value2) {
            addCriterion("WorkSheetNo between", value1, value2, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorksheetnoNotBetween(String value1, String value2) {
            addCriterion("WorkSheetNo not between", value1, value2, "worksheetno");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeIsNull() {
            addCriterion("WorkOrderType is null");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeIsNotNull() {
            addCriterion("WorkOrderType is not null");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeEqualTo(Integer value) {
            addCriterion("WorkOrderType =", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeNotEqualTo(Integer value) {
            addCriterion("WorkOrderType <>", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeGreaterThan(Integer value) {
            addCriterion("WorkOrderType >", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WorkOrderType >=", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeLessThan(Integer value) {
            addCriterion("WorkOrderType <", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeLessThanOrEqualTo(Integer value) {
            addCriterion("WorkOrderType <=", value, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeIn(List<Integer> values) {
            addCriterion("WorkOrderType in", values, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeNotIn(List<Integer> values) {
            addCriterion("WorkOrderType not in", values, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeBetween(Integer value1, Integer value2) {
            addCriterion("WorkOrderType between", value1, value2, "workordertype");
            return (Criteria) this;
        }

        public Criteria andWorkordertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("WorkOrderType not between", value1, value2, "workordertype");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIsNull() {
            addCriterion("RequestCode is null");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIsNotNull() {
            addCriterion("RequestCode is not null");
            return (Criteria) this;
        }

        public Criteria andRequestcodeEqualTo(String value) {
            addCriterion("RequestCode =", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotEqualTo(String value) {
            addCriterion("RequestCode <>", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThan(String value) {
            addCriterion("RequestCode >", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThanOrEqualTo(String value) {
            addCriterion("RequestCode >=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThan(String value) {
            addCriterion("RequestCode <", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThanOrEqualTo(String value) {
            addCriterion("RequestCode <=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLike(String value) {
            addCriterion("RequestCode like", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotLike(String value) {
            addCriterion("RequestCode not like", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIn(List<String> values) {
            addCriterion("RequestCode in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotIn(List<String> values) {
            addCriterion("RequestCode not in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeBetween(String value1, String value2) {
            addCriterion("RequestCode between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotBetween(String value1, String value2) {
            addCriterion("RequestCode not between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequeststateIsNull() {
            addCriterion("RequestState is null");
            return (Criteria) this;
        }

        public Criteria andRequeststateIsNotNull() {
            addCriterion("RequestState is not null");
            return (Criteria) this;
        }

        public Criteria andRequeststateEqualTo(Integer value) {
            addCriterion("RequestState =", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateNotEqualTo(Integer value) {
            addCriterion("RequestState <>", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateGreaterThan(Integer value) {
            addCriterion("RequestState >", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateGreaterThanOrEqualTo(Integer value) {
            addCriterion("RequestState >=", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateLessThan(Integer value) {
            addCriterion("RequestState <", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateLessThanOrEqualTo(Integer value) {
            addCriterion("RequestState <=", value, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateIn(List<Integer> values) {
            addCriterion("RequestState in", values, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateNotIn(List<Integer> values) {
            addCriterion("RequestState not in", values, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateBetween(Integer value1, Integer value2) {
            addCriterion("RequestState between", value1, value2, "requeststate");
            return (Criteria) this;
        }

        public Criteria andRequeststateNotBetween(Integer value1, Integer value2) {
            addCriterion("RequestState not between", value1, value2, "requeststate");
            return (Criteria) this;
        }

        public Criteria andConfirmorIsNull() {
            addCriterion("Confirmor is null");
            return (Criteria) this;
        }

        public Criteria andConfirmorIsNotNull() {
            addCriterion("Confirmor is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmorEqualTo(String value) {
            addCriterion("Confirmor =", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorNotEqualTo(String value) {
            addCriterion("Confirmor <>", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorGreaterThan(String value) {
            addCriterion("Confirmor >", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorGreaterThanOrEqualTo(String value) {
            addCriterion("Confirmor >=", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorLessThan(String value) {
            addCriterion("Confirmor <", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorLessThanOrEqualTo(String value) {
            addCriterion("Confirmor <=", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorLike(String value) {
            addCriterion("Confirmor like", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorNotLike(String value) {
            addCriterion("Confirmor not like", value, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorIn(List<String> values) {
            addCriterion("Confirmor in", values, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorNotIn(List<String> values) {
            addCriterion("Confirmor not in", values, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorBetween(String value1, String value2) {
            addCriterion("Confirmor between", value1, value2, "confirmor");
            return (Criteria) this;
        }

        public Criteria andConfirmorNotBetween(String value1, String value2) {
            addCriterion("Confirmor not between", value1, value2, "confirmor");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNull() {
            addCriterion("RequestTime is null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNotNull() {
            addCriterion("RequestTime is not null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeEqualTo(Date value) {
            addCriterion("RequestTime =", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotEqualTo(Date value) {
            addCriterion("RequestTime <>", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThan(Date value) {
            addCriterion("RequestTime >", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RequestTime >=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThan(Date value) {
            addCriterion("RequestTime <", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThanOrEqualTo(Date value) {
            addCriterion("RequestTime <=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIn(List<Date> values) {
            addCriterion("RequestTime in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotIn(List<Date> values) {
            addCriterion("RequestTime not in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeBetween(Date value1, Date value2) {
            addCriterion("RequestTime between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotBetween(Date value1, Date value2) {
            addCriterion("RequestTime not between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andSigntypeIsNull() {
            addCriterion("SignType is null");
            return (Criteria) this;
        }

        public Criteria andSigntypeIsNotNull() {
            addCriterion("SignType is not null");
            return (Criteria) this;
        }

        public Criteria andSigntypeEqualTo(Integer value) {
            addCriterion("SignType =", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotEqualTo(Integer value) {
            addCriterion("SignType <>", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeGreaterThan(Integer value) {
            addCriterion("SignType >", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SignType >=", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeLessThan(Integer value) {
            addCriterion("SignType <", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeLessThanOrEqualTo(Integer value) {
            addCriterion("SignType <=", value, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeIn(List<Integer> values) {
            addCriterion("SignType in", values, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotIn(List<Integer> values) {
            addCriterion("SignType not in", values, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeBetween(Integer value1, Integer value2) {
            addCriterion("SignType between", value1, value2, "signtype");
            return (Criteria) this;
        }

        public Criteria andSigntypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SignType not between", value1, value2, "signtype");
            return (Criteria) this;
        }

        public Criteria andCourierintIsNull() {
            addCriterion("CourierInt is null");
            return (Criteria) this;
        }

        public Criteria andCourierintIsNotNull() {
            addCriterion("CourierInt is not null");
            return (Criteria) this;
        }

        public Criteria andCourierintEqualTo(Integer value) {
            addCriterion("CourierInt =", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintNotEqualTo(Integer value) {
            addCriterion("CourierInt <>", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintGreaterThan(Integer value) {
            addCriterion("CourierInt >", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourierInt >=", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintLessThan(Integer value) {
            addCriterion("CourierInt <", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintLessThanOrEqualTo(Integer value) {
            addCriterion("CourierInt <=", value, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintIn(List<Integer> values) {
            addCriterion("CourierInt in", values, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintNotIn(List<Integer> values) {
            addCriterion("CourierInt not in", values, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintBetween(Integer value1, Integer value2) {
            addCriterion("CourierInt between", value1, value2, "courierint");
            return (Criteria) this;
        }

        public Criteria andCourierintNotBetween(Integer value1, Integer value2) {
            addCriterion("CourierInt not between", value1, value2, "courierint");
            return (Criteria) this;
        }

        public Criteria andCouriernameIsNull() {
            addCriterion("CourierName is null");
            return (Criteria) this;
        }

        public Criteria andCouriernameIsNotNull() {
            addCriterion("CourierName is not null");
            return (Criteria) this;
        }

        public Criteria andCouriernameEqualTo(String value) {
            addCriterion("CourierName =", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotEqualTo(String value) {
            addCriterion("CourierName <>", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameGreaterThan(String value) {
            addCriterion("CourierName >", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameGreaterThanOrEqualTo(String value) {
            addCriterion("CourierName >=", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLessThan(String value) {
            addCriterion("CourierName <", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLessThanOrEqualTo(String value) {
            addCriterion("CourierName <=", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameLike(String value) {
            addCriterion("CourierName like", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotLike(String value) {
            addCriterion("CourierName not like", value, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameIn(List<String> values) {
            addCriterion("CourierName in", values, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotIn(List<String> values) {
            addCriterion("CourierName not in", values, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameBetween(String value1, String value2) {
            addCriterion("CourierName between", value1, value2, "couriername");
            return (Criteria) this;
        }

        public Criteria andCouriernameNotBetween(String value1, String value2) {
            addCriterion("CourierName not between", value1, value2, "couriername");
            return (Criteria) this;
        }

        public Criteria andRecipientIsNull() {
            addCriterion("Recipient is null");
            return (Criteria) this;
        }

        public Criteria andRecipientIsNotNull() {
            addCriterion("Recipient is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientEqualTo(String value) {
            addCriterion("Recipient =", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientNotEqualTo(String value) {
            addCriterion("Recipient <>", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientGreaterThan(String value) {
            addCriterion("Recipient >", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientGreaterThanOrEqualTo(String value) {
            addCriterion("Recipient >=", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientLessThan(String value) {
            addCriterion("Recipient <", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientLessThanOrEqualTo(String value) {
            addCriterion("Recipient <=", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientLike(String value) {
            addCriterion("Recipient like", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientNotLike(String value) {
            addCriterion("Recipient not like", value, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientIn(List<String> values) {
            addCriterion("Recipient in", values, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientNotIn(List<String> values) {
            addCriterion("Recipient not in", values, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientBetween(String value1, String value2) {
            addCriterion("Recipient between", value1, value2, "recipient");
            return (Criteria) this;
        }

        public Criteria andRecipientNotBetween(String value1, String value2) {
            addCriterion("Recipient not between", value1, value2, "recipient");
            return (Criteria) this;
        }

        public Criteria andSignunitIsNull() {
            addCriterion("SignUnit is null");
            return (Criteria) this;
        }

        public Criteria andSignunitIsNotNull() {
            addCriterion("SignUnit is not null");
            return (Criteria) this;
        }

        public Criteria andSignunitEqualTo(Integer value) {
            addCriterion("SignUnit =", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitNotEqualTo(Integer value) {
            addCriterion("SignUnit <>", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitGreaterThan(Integer value) {
            addCriterion("SignUnit >", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitGreaterThanOrEqualTo(Integer value) {
            addCriterion("SignUnit >=", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitLessThan(Integer value) {
            addCriterion("SignUnit <", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitLessThanOrEqualTo(Integer value) {
            addCriterion("SignUnit <=", value, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitIn(List<Integer> values) {
            addCriterion("SignUnit in", values, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitNotIn(List<Integer> values) {
            addCriterion("SignUnit not in", values, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitBetween(Integer value1, Integer value2) {
            addCriterion("SignUnit between", value1, value2, "signunit");
            return (Criteria) this;
        }

        public Criteria andSignunitNotBetween(Integer value1, Integer value2) {
            addCriterion("SignUnit not between", value1, value2, "signunit");
            return (Criteria) this;
        }

        public Criteria andSigntimeIsNull() {
            addCriterion("SignTime is null");
            return (Criteria) this;
        }

        public Criteria andSigntimeIsNotNull() {
            addCriterion("SignTime is not null");
            return (Criteria) this;
        }

        public Criteria andSigntimeEqualTo(Date value) {
            addCriterion("SignTime =", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotEqualTo(Date value) {
            addCriterion("SignTime <>", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeGreaterThan(Date value) {
            addCriterion("SignTime >", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SignTime >=", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeLessThan(Date value) {
            addCriterion("SignTime <", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeLessThanOrEqualTo(Date value) {
            addCriterion("SignTime <=", value, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeIn(List<Date> values) {
            addCriterion("SignTime in", values, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotIn(List<Date> values) {
            addCriterion("SignTime not in", values, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeBetween(Date value1, Date value2) {
            addCriterion("SignTime between", value1, value2, "signtime");
            return (Criteria) this;
        }

        public Criteria andSigntimeNotBetween(Date value1, Date value2) {
            addCriterion("SignTime not between", value1, value2, "signtime");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkIsNull() {
            addCriterion("InvalidateMark is null");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkIsNotNull() {
            addCriterion("InvalidateMark is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkEqualTo(Integer value) {
            addCriterion("InvalidateMark =", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkNotEqualTo(Integer value) {
            addCriterion("InvalidateMark <>", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkGreaterThan(Integer value) {
            addCriterion("InvalidateMark >", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("InvalidateMark >=", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkLessThan(Integer value) {
            addCriterion("InvalidateMark <", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkLessThanOrEqualTo(Integer value) {
            addCriterion("InvalidateMark <=", value, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkIn(List<Integer> values) {
            addCriterion("InvalidateMark in", values, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkNotIn(List<Integer> values) {
            addCriterion("InvalidateMark not in", values, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkBetween(Integer value1, Integer value2) {
            addCriterion("InvalidateMark between", value1, value2, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andInvalidatemarkNotBetween(Integer value1, Integer value2) {
            addCriterion("InvalidateMark not between", value1, value2, "invalidatemark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkIsNull() {
            addCriterion("AbnormalMark is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkIsNotNull() {
            addCriterion("AbnormalMark is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkEqualTo(String value) {
            addCriterion("AbnormalMark =", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkNotEqualTo(String value) {
            addCriterion("AbnormalMark <>", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkGreaterThan(String value) {
            addCriterion("AbnormalMark >", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkGreaterThanOrEqualTo(String value) {
            addCriterion("AbnormalMark >=", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkLessThan(String value) {
            addCriterion("AbnormalMark <", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkLessThanOrEqualTo(String value) {
            addCriterion("AbnormalMark <=", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkLike(String value) {
            addCriterion("AbnormalMark like", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkNotLike(String value) {
            addCriterion("AbnormalMark not like", value, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkIn(List<String> values) {
            addCriterion("AbnormalMark in", values, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkNotIn(List<String> values) {
            addCriterion("AbnormalMark not in", values, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkBetween(String value1, String value2) {
            addCriterion("AbnormalMark between", value1, value2, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andAbnormalmarkNotBetween(String value1, String value2) {
            addCriterion("AbnormalMark not between", value1, value2, "abnormalmark");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeIsNull() {
            addCriterion("InputPersonCode is null");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeIsNotNull() {
            addCriterion("InputPersonCode is not null");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeEqualTo(Integer value) {
            addCriterion("InputPersonCode =", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeNotEqualTo(Integer value) {
            addCriterion("InputPersonCode <>", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeGreaterThan(Integer value) {
            addCriterion("InputPersonCode >", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("InputPersonCode >=", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeLessThan(Integer value) {
            addCriterion("InputPersonCode <", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeLessThanOrEqualTo(Integer value) {
            addCriterion("InputPersonCode <=", value, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeIn(List<Integer> values) {
            addCriterion("InputPersonCode in", values, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeNotIn(List<Integer> values) {
            addCriterion("InputPersonCode not in", values, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeBetween(Integer value1, Integer value2) {
            addCriterion("InputPersonCode between", value1, value2, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersoncodeNotBetween(Integer value1, Integer value2) {
            addCriterion("InputPersonCode not between", value1, value2, "inputpersoncode");
            return (Criteria) this;
        }

        public Criteria andInputpersonidIsNull() {
            addCriterion("InputPersonID is null");
            return (Criteria) this;
        }

        public Criteria andInputpersonidIsNotNull() {
            addCriterion("InputPersonID is not null");
            return (Criteria) this;
        }

        public Criteria andInputpersonidEqualTo(Integer value) {
            addCriterion("InputPersonID =", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidNotEqualTo(Integer value) {
            addCriterion("InputPersonID <>", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidGreaterThan(Integer value) {
            addCriterion("InputPersonID >", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidGreaterThanOrEqualTo(Integer value) {
            addCriterion("InputPersonID >=", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidLessThan(Integer value) {
            addCriterion("InputPersonID <", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidLessThanOrEqualTo(Integer value) {
            addCriterion("InputPersonID <=", value, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidIn(List<Integer> values) {
            addCriterion("InputPersonID in", values, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidNotIn(List<Integer> values) {
            addCriterion("InputPersonID not in", values, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidBetween(Integer value1, Integer value2) {
            addCriterion("InputPersonID between", value1, value2, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputpersonidNotBetween(Integer value1, Integer value2) {
            addCriterion("InputPersonID not between", value1, value2, "inputpersonid");
            return (Criteria) this;
        }

        public Criteria andInputidIsNull() {
            addCriterion("InputID is null");
            return (Criteria) this;
        }

        public Criteria andInputidIsNotNull() {
            addCriterion("InputID is not null");
            return (Criteria) this;
        }

        public Criteria andInputidEqualTo(Integer value) {
            addCriterion("InputID =", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidNotEqualTo(Integer value) {
            addCriterion("InputID <>", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidGreaterThan(Integer value) {
            addCriterion("InputID >", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidGreaterThanOrEqualTo(Integer value) {
            addCriterion("InputID >=", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidLessThan(Integer value) {
            addCriterion("InputID <", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidLessThanOrEqualTo(Integer value) {
            addCriterion("InputID <=", value, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidIn(List<Integer> values) {
            addCriterion("InputID in", values, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidNotIn(List<Integer> values) {
            addCriterion("InputID not in", values, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidBetween(Integer value1, Integer value2) {
            addCriterion("InputID between", value1, value2, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputidNotBetween(Integer value1, Integer value2) {
            addCriterion("InputID not between", value1, value2, "inputid");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNull() {
            addCriterion("InputTime is null");
            return (Criteria) this;
        }

        public Criteria andInputtimeIsNotNull() {
            addCriterion("InputTime is not null");
            return (Criteria) this;
        }

        public Criteria andInputtimeEqualTo(Date value) {
            addCriterion("InputTime =", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotEqualTo(Date value) {
            addCriterion("InputTime <>", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThan(Date value) {
            addCriterion("InputTime >", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("InputTime >=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThan(Date value) {
            addCriterion("InputTime <", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeLessThanOrEqualTo(Date value) {
            addCriterion("InputTime <=", value, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeIn(List<Date> values) {
            addCriterion("InputTime in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotIn(List<Date> values) {
            addCriterion("InputTime not in", values, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeBetween(Date value1, Date value2) {
            addCriterion("InputTime between", value1, value2, "inputtime");
            return (Criteria) this;
        }

        public Criteria andInputtimeNotBetween(Date value1, Date value2) {
            addCriterion("InputTime not between", value1, value2, "inputtime");
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