package com.rivet.api.resources.cloud.version.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Route.Builder.class)
public final class Route {
    private final String glob;

    private final int priority;

    private final List<Middleware> middlewares;

    private Route(String glob, int priority, List<Middleware> middlewares) {
        this.glob = glob;
        this.priority = priority;
        this.middlewares = middlewares;
    }

    @JsonProperty("glob")
    public String getGlob() {
        return glob;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("priority")
    public int getPriority() {
        return priority;
    }

    /**
     * @return Multiple CDN version middleware.
     */
    @JsonProperty("middlewares")
    public List<Middleware> getMiddlewares() {
        return middlewares;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Route && equalTo((Route) other);
    }

    private boolean equalTo(Route other) {
        return glob.equals(other.glob) && priority == other.priority && middlewares.equals(other.middlewares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.glob, this.priority, this.middlewares);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GlobStage builder() {
        return new Builder();
    }

    public interface GlobStage {
        PriorityStage glob(String glob);

        Builder from(Route other);
    }

    public interface PriorityStage {
        _FinalStage priority(int priority);
    }

    public interface _FinalStage {
        Route build();

        _FinalStage middlewares(List<Middleware> middlewares);

        _FinalStage addMiddlewares(Middleware middlewares);

        _FinalStage addAllMiddlewares(List<Middleware> middlewares);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GlobStage, PriorityStage, _FinalStage {
        private String glob;

        private int priority;

        private List<Middleware> middlewares = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(Route other) {
            glob(other.getGlob());
            priority(other.getPriority());
            middlewares(other.getMiddlewares());
            return this;
        }

        @Override
        @JsonSetter("glob")
        public PriorityStage glob(String glob) {
            this.glob = glob;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("priority")
        public _FinalStage priority(int priority) {
            this.priority = priority;
            return this;
        }

        /**
         * <p>Multiple CDN version middleware.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllMiddlewares(List<Middleware> middlewares) {
            this.middlewares.addAll(middlewares);
            return this;
        }

        /**
         * <p>Multiple CDN version middleware.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addMiddlewares(Middleware middlewares) {
            this.middlewares.add(middlewares);
            return this;
        }

        @Override
        @JsonSetter(value = "middlewares", nulls = Nulls.SKIP)
        public _FinalStage middlewares(List<Middleware> middlewares) {
            this.middlewares.clear();
            this.middlewares.addAll(middlewares);
            return this;
        }

        @Override
        public Route build() {
            return new Route(glob, priority, middlewares);
        }
    }
}
