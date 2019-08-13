package com.lesson.dispatch.entity;

import java.util.ArrayList;
import java.util.List;

public class BasZoneInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BasZoneInfoExample() {
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

        public Criteria andZonecodeIsNull() {
            addCriterion("zoneCode is null");
            return (Criteria) this;
        }

        public Criteria andZonecodeIsNotNull() {
            addCriterion("zoneCode is not null");
            return (Criteria) this;
        }

        public Criteria andZonecodeEqualTo(String value) {
            addCriterion("zoneCode =", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotEqualTo(String value) {
            addCriterion("zoneCode <>", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeGreaterThan(String value) {
            addCriterion("zoneCode >", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeGreaterThanOrEqualTo(String value) {
            addCriterion("zoneCode >=", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLessThan(String value) {
            addCriterion("zoneCode <", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLessThanOrEqualTo(String value) {
            addCriterion("zoneCode <=", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLike(String value) {
            addCriterion("zoneCode like", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotLike(String value) {
            addCriterion("zoneCode not like", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeIn(List<String> values) {
            addCriterion("zoneCode in", values, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotIn(List<String> values) {
            addCriterion("zoneCode not in", values, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeBetween(String value1, String value2) {
            addCriterion("zoneCode between", value1, value2, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotBetween(String value1, String value2) {
            addCriterion("zoneCode not between", value1, value2, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNull() {
            addCriterion("zoneName is null");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNotNull() {
            addCriterion("zoneName is not null");
            return (Criteria) this;
        }

        public Criteria andZonenameEqualTo(String value) {
            addCriterion("zoneName =", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotEqualTo(String value) {
            addCriterion("zoneName <>", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThan(String value) {
            addCriterion("zoneName >", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThanOrEqualTo(String value) {
            addCriterion("zoneName >=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThan(String value) {
            addCriterion("zoneName <", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThanOrEqualTo(String value) {
            addCriterion("zoneName <=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLike(String value) {
            addCriterion("zoneName like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotLike(String value) {
            addCriterion("zoneName not like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameIn(List<String> values) {
            addCriterion("zoneName in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotIn(List<String> values) {
            addCriterion("zoneName not in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameBetween(String value1, String value2) {
            addCriterion("zoneName between", value1, value2, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotBetween(String value1, String value2) {
            addCriterion("zoneName not between", value1, value2, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonepeopleIsNull() {
            addCriterion("zonePeople is null");
            return (Criteria) this;
        }

        public Criteria andZonepeopleIsNotNull() {
            addCriterion("zonePeople is not null");
            return (Criteria) this;
        }

        public Criteria andZonepeopleEqualTo(Integer value) {
            addCriterion("zonePeople =", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleNotEqualTo(Integer value) {
            addCriterion("zonePeople <>", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleGreaterThan(Integer value) {
            addCriterion("zonePeople >", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("zonePeople >=", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleLessThan(Integer value) {
            addCriterion("zonePeople <", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleLessThanOrEqualTo(Integer value) {
            addCriterion("zonePeople <=", value, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleIn(List<Integer> values) {
            addCriterion("zonePeople in", values, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleNotIn(List<Integer> values) {
            addCriterion("zonePeople not in", values, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleBetween(Integer value1, Integer value2) {
            addCriterion("zonePeople between", value1, value2, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andZonepeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("zonePeople not between", value1, value2, "zonepeople");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("telPhone is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("telPhone is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(String value) {
            addCriterion("telPhone =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(String value) {
            addCriterion("telPhone <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(String value) {
            addCriterion("telPhone >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("telPhone >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(String value) {
            addCriterion("telPhone <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(String value) {
            addCriterion("telPhone <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLike(String value) {
            addCriterion("telPhone like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotLike(String value) {
            addCriterion("telPhone not like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<String> values) {
            addCriterion("telPhone in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<String> values) {
            addCriterion("telPhone not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(String value1, String value2) {
            addCriterion("telPhone between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(String value1, String value2) {
            addCriterion("telPhone not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitIsNull() {
            addCriterion("bubordinateUnit is null");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitIsNotNull() {
            addCriterion("bubordinateUnit is not null");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitEqualTo(Integer value) {
            addCriterion("bubordinateUnit =", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitNotEqualTo(Integer value) {
            addCriterion("bubordinateUnit <>", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitGreaterThan(Integer value) {
            addCriterion("bubordinateUnit >", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitGreaterThanOrEqualTo(Integer value) {
            addCriterion("bubordinateUnit >=", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitLessThan(Integer value) {
            addCriterion("bubordinateUnit <", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitLessThanOrEqualTo(Integer value) {
            addCriterion("bubordinateUnit <=", value, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitIn(List<Integer> values) {
            addCriterion("bubordinateUnit in", values, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitNotIn(List<Integer> values) {
            addCriterion("bubordinateUnit not in", values, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitBetween(Integer value1, Integer value2) {
            addCriterion("bubordinateUnit between", value1, value2, "bubordinateunit");
            return (Criteria) this;
        }

        public Criteria andBubordinateunitNotBetween(Integer value1, Integer value2) {
            addCriterion("bubordinateUnit not between", value1, value2, "bubordinateunit");
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