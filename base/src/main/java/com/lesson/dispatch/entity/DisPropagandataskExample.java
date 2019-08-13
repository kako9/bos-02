package com.lesson.dispatch.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisPropagandataskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DisPropagandataskExample() {
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

        public Criteria andOutlineIsNull() {
            addCriterion("Outline is null");
            return (Criteria) this;
        }

        public Criteria andOutlineIsNotNull() {
            addCriterion("Outline is not null");
            return (Criteria) this;
        }

        public Criteria andOutlineEqualTo(String value) {
            addCriterion("Outline =", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotEqualTo(String value) {
            addCriterion("Outline <>", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThan(String value) {
            addCriterion("Outline >", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineGreaterThanOrEqualTo(String value) {
            addCriterion("Outline >=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThan(String value) {
            addCriterion("Outline <", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLessThanOrEqualTo(String value) {
            addCriterion("Outline <=", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineLike(String value) {
            addCriterion("Outline like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotLike(String value) {
            addCriterion("Outline not like", value, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineIn(List<String> values) {
            addCriterion("Outline in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotIn(List<String> values) {
            addCriterion("Outline not in", values, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineBetween(String value1, String value2) {
            addCriterion("Outline between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andOutlineNotBetween(String value1, String value2) {
            addCriterion("Outline not between", value1, value2, "outline");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("ReleaseTime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("ReleaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterion("ReleaseTime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterion("ReleaseTime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterion("ReleaseTime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ReleaseTime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterion("ReleaseTime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterion("ReleaseTime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterion("ReleaseTime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterion("ReleaseTime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterion("ReleaseTime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterion("ReleaseTime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeIsNull() {
            addCriterion("FailureTime is null");
            return (Criteria) this;
        }

        public Criteria andFailuretimeIsNotNull() {
            addCriterion("FailureTime is not null");
            return (Criteria) this;
        }

        public Criteria andFailuretimeEqualTo(Date value) {
            addCriterion("FailureTime =", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeNotEqualTo(Date value) {
            addCriterion("FailureTime <>", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeGreaterThan(Date value) {
            addCriterion("FailureTime >", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FailureTime >=", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeLessThan(Date value) {
            addCriterion("FailureTime <", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeLessThanOrEqualTo(Date value) {
            addCriterion("FailureTime <=", value, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeIn(List<Date> values) {
            addCriterion("FailureTime in", values, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeNotIn(List<Date> values) {
            addCriterion("FailureTime not in", values, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeBetween(Date value1, Date value2) {
            addCriterion("FailureTime between", value1, value2, "failuretime");
            return (Criteria) this;
        }

        public Criteria andFailuretimeNotBetween(Date value1, Date value2) {
            addCriterion("FailureTime not between", value1, value2, "failuretime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
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