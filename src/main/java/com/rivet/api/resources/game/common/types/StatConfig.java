package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = StatConfig.Builder.class)
public final class StatConfig {
    private final UUID recordId;

    private final UUID iconId;

    private final StatFormatMethod format;

    private final StatAggregationMethod aggregation;

    private final StatSortingMethod sorting;

    private final int priority;

    private final String displayName;

    private final Optional<String> postfixSingular;

    private final Optional<String> postfixPlural;

    private final Optional<String> prefixSingular;

    private final Optional<String> prefixPlural;

    private StatConfig(
            UUID recordId,
            UUID iconId,
            StatFormatMethod format,
            StatAggregationMethod aggregation,
            StatSortingMethod sorting,
            int priority,
            String displayName,
            Optional<String> postfixSingular,
            Optional<String> postfixPlural,
            Optional<String> prefixSingular,
            Optional<String> prefixPlural) {
        this.recordId = recordId;
        this.iconId = iconId;
        this.format = format;
        this.aggregation = aggregation;
        this.sorting = sorting;
        this.priority = priority;
        this.displayName = displayName;
        this.postfixSingular = postfixSingular;
        this.postfixPlural = postfixPlural;
        this.prefixSingular = prefixSingular;
        this.prefixPlural = prefixPlural;
    }

    @JsonProperty("record_id")
    public UUID getRecordId() {
        return recordId;
    }

    @JsonProperty("icon_id")
    public UUID getIconId() {
        return iconId;
    }

    @JsonProperty("format")
    public StatFormatMethod getFormat() {
        return format;
    }

    @JsonProperty("aggregation")
    public StatAggregationMethod getAggregation() {
        return aggregation;
    }

    @JsonProperty("sorting")
    public StatSortingMethod getSorting() {
        return sorting;
    }

    @JsonProperty("priority")
    public int getPriority() {
        return priority;
    }

    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return A string appended to the end of a singular game statistic's value. Example: 1 <strong>dollar</strong>.
     */
    @JsonProperty("postfix_singular")
    public Optional<String> getPostfixSingular() {
        return postfixSingular;
    }

    /**
     * @return A string appended to the end of a game statistic's value that is not exactly 1. Example: 45 <strong>dollars</strong>.
     */
    @JsonProperty("postfix_plural")
    public Optional<String> getPostfixPlural() {
        return postfixPlural;
    }

    /**
     * @return A string appended to the beginning of a singular game statistic's value. Example: <strong>value</strong> 1.
     */
    @JsonProperty("prefix_singular")
    public Optional<String> getPrefixSingular() {
        return prefixSingular;
    }

    /**
     * @return A string prepended to the beginning of a game statistic's value that is not exactly 1. Example: <strong>values</strong> 45.
     */
    @JsonProperty("prefix_plural")
    public Optional<String> getPrefixPlural() {
        return prefixPlural;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StatConfig && equalTo((StatConfig) other);
    }

    private boolean equalTo(StatConfig other) {
        return recordId.equals(other.recordId)
                && iconId.equals(other.iconId)
                && format.equals(other.format)
                && aggregation.equals(other.aggregation)
                && sorting.equals(other.sorting)
                && priority == other.priority
                && displayName.equals(other.displayName)
                && postfixSingular.equals(other.postfixSingular)
                && postfixPlural.equals(other.postfixPlural)
                && prefixSingular.equals(other.prefixSingular)
                && prefixPlural.equals(other.prefixPlural);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.recordId,
                this.iconId,
                this.format,
                this.aggregation,
                this.sorting,
                this.priority,
                this.displayName,
                this.postfixSingular,
                this.postfixPlural,
                this.prefixSingular,
                this.prefixPlural);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RecordIdStage builder() {
        return new Builder();
    }

    public interface RecordIdStage {
        IconIdStage recordId(UUID recordId);

        Builder from(StatConfig other);
    }

    public interface IconIdStage {
        FormatStage iconId(UUID iconId);
    }

    public interface FormatStage {
        AggregationStage format(StatFormatMethod format);
    }

    public interface AggregationStage {
        SortingStage aggregation(StatAggregationMethod aggregation);
    }

    public interface SortingStage {
        PriorityStage sorting(StatSortingMethod sorting);
    }

    public interface PriorityStage {
        DisplayNameStage priority(int priority);
    }

    public interface DisplayNameStage {
        _FinalStage displayName(String displayName);
    }

    public interface _FinalStage {
        StatConfig build();

        _FinalStage postfixSingular(Optional<String> postfixSingular);

        _FinalStage postfixSingular(String postfixSingular);

        _FinalStage postfixPlural(Optional<String> postfixPlural);

        _FinalStage postfixPlural(String postfixPlural);

        _FinalStage prefixSingular(Optional<String> prefixSingular);

        _FinalStage prefixSingular(String prefixSingular);

        _FinalStage prefixPlural(Optional<String> prefixPlural);

        _FinalStage prefixPlural(String prefixPlural);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements RecordIdStage,
                    IconIdStage,
                    FormatStage,
                    AggregationStage,
                    SortingStage,
                    PriorityStage,
                    DisplayNameStage,
                    _FinalStage {
        private UUID recordId;

        private UUID iconId;

        private StatFormatMethod format;

        private StatAggregationMethod aggregation;

        private StatSortingMethod sorting;

        private int priority;

        private String displayName;

        private Optional<String> prefixPlural = Optional.empty();

        private Optional<String> prefixSingular = Optional.empty();

        private Optional<String> postfixPlural = Optional.empty();

        private Optional<String> postfixSingular = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(StatConfig other) {
            recordId(other.getRecordId());
            iconId(other.getIconId());
            format(other.getFormat());
            aggregation(other.getAggregation());
            sorting(other.getSorting());
            priority(other.getPriority());
            displayName(other.getDisplayName());
            postfixSingular(other.getPostfixSingular());
            postfixPlural(other.getPostfixPlural());
            prefixSingular(other.getPrefixSingular());
            prefixPlural(other.getPrefixPlural());
            return this;
        }

        @Override
        @JsonSetter("record_id")
        public IconIdStage recordId(UUID recordId) {
            this.recordId = recordId;
            return this;
        }

        @Override
        @JsonSetter("icon_id")
        public FormatStage iconId(UUID iconId) {
            this.iconId = iconId;
            return this;
        }

        @Override
        @JsonSetter("format")
        public AggregationStage format(StatFormatMethod format) {
            this.format = format;
            return this;
        }

        @Override
        @JsonSetter("aggregation")
        public SortingStage aggregation(StatAggregationMethod aggregation) {
            this.aggregation = aggregation;
            return this;
        }

        @Override
        @JsonSetter("sorting")
        public PriorityStage sorting(StatSortingMethod sorting) {
            this.sorting = sorting;
            return this;
        }

        @Override
        @JsonSetter("priority")
        public DisplayNameStage priority(int priority) {
            this.priority = priority;
            return this;
        }

        @Override
        @JsonSetter("display_name")
        public _FinalStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * <p>A string prepended to the beginning of a game statistic's value that is not exactly 1. Example: <strong>values</strong> 45.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage prefixPlural(String prefixPlural) {
            this.prefixPlural = Optional.of(prefixPlural);
            return this;
        }

        @Override
        @JsonSetter(value = "prefix_plural", nulls = Nulls.SKIP)
        public _FinalStage prefixPlural(Optional<String> prefixPlural) {
            this.prefixPlural = prefixPlural;
            return this;
        }

        /**
         * <p>A string appended to the beginning of a singular game statistic's value. Example: <strong>value</strong> 1.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage prefixSingular(String prefixSingular) {
            this.prefixSingular = Optional.of(prefixSingular);
            return this;
        }

        @Override
        @JsonSetter(value = "prefix_singular", nulls = Nulls.SKIP)
        public _FinalStage prefixSingular(Optional<String> prefixSingular) {
            this.prefixSingular = prefixSingular;
            return this;
        }

        /**
         * <p>A string appended to the end of a game statistic's value that is not exactly 1. Example: 45 <strong>dollars</strong>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage postfixPlural(String postfixPlural) {
            this.postfixPlural = Optional.of(postfixPlural);
            return this;
        }

        @Override
        @JsonSetter(value = "postfix_plural", nulls = Nulls.SKIP)
        public _FinalStage postfixPlural(Optional<String> postfixPlural) {
            this.postfixPlural = postfixPlural;
            return this;
        }

        /**
         * <p>A string appended to the end of a singular game statistic's value. Example: 1 <strong>dollar</strong>.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage postfixSingular(String postfixSingular) {
            this.postfixSingular = Optional.of(postfixSingular);
            return this;
        }

        @Override
        @JsonSetter(value = "postfix_singular", nulls = Nulls.SKIP)
        public _FinalStage postfixSingular(Optional<String> postfixSingular) {
            this.postfixSingular = postfixSingular;
            return this;
        }

        @Override
        public StatConfig build() {
            return new StatConfig(
                    recordId,
                    iconId,
                    format,
                    aggregation,
                    sorting,
                    priority,
                    displayName,
                    postfixSingular,
                    postfixPlural,
                    prefixSingular,
                    prefixPlural);
        }
    }
}
