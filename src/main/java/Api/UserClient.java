package Api;

import constants.Authorization;
import constants.ContentType;
import constants.EndPoints;
import io.qameta.allure.Step;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserClient {
    private static final File createUser = new File("src/test/java/resources/createUser.json");
    private static final File loginUser = new File("src/test/java/resources/loginUser.json");

    @Step("Создание пользователя")
    public void createUser() {
        given()
                .contentType(ContentType.CONTENT_TYPE)
                .body(createUser)
                .when()
                .post(EndPoints.CREATE_USER)
                .then()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Step("Логин пользователя")
    public void loginUser() {
        Authorization.ACCESS_TOKEN = given()
                .contentType(ContentType.CONTENT_TYPE)
                .body(loginUser)
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(200)
                .extract().body().path("accessToken");
    }

    @Step("Удаление пользователя")
    public void deleteUser() {
        Authorization.ACCESS_TOKEN = given()
                .contentType(ContentType.CONTENT_TYPE)
                .body(loginUser)
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .extract().body().path("accessToken");
        given()
                .contentType(ContentType.CONTENT_TYPE)
                .header(Authorization.AUTHORIZATION, Authorization.ACCESS_TOKEN)
                .when()
                .delete(EndPoints.PATCH_USER);

    }
}
