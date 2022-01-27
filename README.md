<img src="https://cdn.jsdelivr.net/gh/shiyindaxiaojie/images/readme/icon.png" align="right" />

# 项目脚手架
![](https://cdn.jsdelivr.net/gh/shiyindaxiaojie/images/readme/language-java-blue.svg) ![](https://cdn.jsdelivr.net/gh/shiyindaxiaojie/images/readme/license-apache2.0-red.svg) ![](https://github.com/eden-lab/eden-archetype/workflows/build/badge.svg) ![](https://sonarcloud.io/api/project_badges/measure?project=eden-lab_eden-archetype&metric=alert_status)

很多开发者在使用 `start.spring.io` 生成的工程骨架中，只有组件坐标信息，缺少对应的使用方法和 Demo 代码，开发者还是需要去寻找相关使用教程，或者样例代码，如果找的不对，或者是版本不匹匹配，还需要花费不少时间去排查和解决问题，这些问题都在无形中增加用户的工作量。基于我们打造的项目脚手架，提供了一套企业级通用的项目生成解决方案，您可以选择不同的架构风格来创建您的应用。

> 参考文档请查看 [WIKI](https://github.com/eden-lab/eden-archetype/wiki) 。

## 组件构成

* **eden-archetype-cola**：COLA 架构脚手架
* **eden-archetype-layer**：分层架构脚手架

## 如何构建
* master 分支对应的是 `eden-archetype 2.4.x`，最低支持 JDK 1.8。
* 1.5.x 分支对应的是 `eden-archetype 1.5.x`，最低支持 JDK 1.8。
* 2.4.x 分支对应的是 `eden-archetype 2.4.x`，最低支持 JDK 1.8。

本项目使用 Maven 来构建，最快的使用方式是 clone 到本地，然后执行以下命令：

```bash
./mvnw install
```

执行完毕后，项目将被安装到本地 Maven 仓库。

## 如何使用

### 通过项目脚手架创建应用

例如，通过我们提供的 `eden-archetype-cola` 创建应用脚手架。

执行以下命令：

```bash
mvn archetype:generate  \
    -DgroupId=org.ylzl.eden.demo \
    -DartifactId=demo-cola \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=org.ylzl.eden.demo \
    -DarchetypeArtifactId=eden-archetype-cola \
    -DarchetypeGroupId=org.ylzl \
    -DarchetypeVersion=2.4.13
```

命令执行成功后会生成预设的目录结构和示例代码。

### 运行应用

- 在 `项目` 目录下运行 `mvn install`（如果不想运行测试，可以加上 `-DskipTests` 参数）。
- 进入 `xxx-start` 目录，执行 `mvn spring-boot:run` 或者启动 `Application` 类。运行成功的话，可以看到 `SpringBoot` 启动成功的界面。
- 生成的应用中，已经实现了一个简单的 `Rest` 请求，可以在浏览器中输入 http://localhost:8080/api/users/1 进行测试。

> 请注意，我们已经把常用的依赖纳入 eden-dependencies 管理，不建议带版本号覆盖原有的依赖。

## 版本规范

项目的版本号格式为 x.x.x 的形式，其中 x 的数值类型为数字，从 0 开始取值，且不限于 0~9 这个范围。项目处于孵化器阶段时，第一位版本号固定使用 0，即版本号为 0.x.x 的格式。

由于 `Spring Boot 1.5.x` 和 `Spring Boot 2.4.x` 在架构层面有很大的变更，因此我们采取跟 Spring Boot 版本号一致的版本:

* 1.5.x 版本适用于 `Spring Boot 1.5.x`
* 2.4.x 版本适用于 `Spring Boot 2.4.x`
