# Rivet Java Library

___

## ❗ DEPRECATION NOTICE ❗

### This repo is being deprecated as all functionality has been moved into [the main repo](https://github.com/rivet-gg/rivet) 
___

[![Maven Central](https://img.shields.io/maven-central/v/gg.rivet/api)](https://central.sonatype.com/artifact/gg.rivet/api) 
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://buildwithfern.com/?utm_source=rivet-gg/rivet-java/readme)

The Rivet Java SDK provides convenient access to the Rivet APIs from Java. 

## Documentation

API documentation is available at [here](https://rivet.gg/docs).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'gg.rivet:api:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>gg.rivet</groupId>
    <artifactId>api</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Instantiation

```java
RivetApiClient rivet = RivetApiClient.builder()
    .token("ACCOUNT_TOKEN")
    .build();
```

## Usage

```java
import com.rivet.api.RivetApiClient;
import com.rivet.api.resources.matchmaker.lobbies.requests.FindLobbyRequest;

RivetApiClient rivet = RivetApiClient.builder()
    .token("ACCOUNT_TOKEN")
    .build();

rivet.matchmaker().lobbies().find(FindLobbyRequest.builder()
  .origin("origin")
  .gameModes(List.of("mode")
  .build());
```

## Staged Builders
The generated builders all follow the staged builder pattern. Read more [here](https://immutables.github.io/immutable.html#staged-builder). 
Staged builders only allow you to build the object once all required properties have been specified. 

## Request Options
Every endpoint has an overloaded equivalent which takes [RequestOptions](./src/main/java/com/rivet/api/core/RequestOptions.java)
that allow you to override the token.

```java
import com.rivet.api.RivetApiClient;
import com.rivet.api.resources.matchmaker.lobbies.requests.FindLobbyRequest;


RivetApiClient rivet = RivetApiClient.builder()
    .token("ACCOUNT_TOKEN")
    .build();

rivet.matchmaker().lobbies().find(
  FindLobbyRequest.builder()
    .origin("origin")
    .gameModes(List.of("mode")
    .build(), 
  RequestOptions.builder()
   .token("override-token")
   .build());
```

## Handling Errors
All errors thrown by the SDK will be a subclass of [ApiError](./src/main/java/com/rivet/api/core/ApiError.java). 

```java
import com.rivet.api.RivetApiClient;
import com.rivet.api.core.ApiErrror;

RivetApiClient rivet = RivetApiClient.builder()
    .token("ACCOUNT_TOKEN")
    .build();

try {
  rivet.cloud().tiers().getRegionTiers();
} catch (ApiError e) {
  // e.getStatusCode();
}
```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
