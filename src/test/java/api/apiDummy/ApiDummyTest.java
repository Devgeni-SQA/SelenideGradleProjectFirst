package api.apiDummy;

import api.Specs.Specifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiDummyTest {

    private final static String UrlDummy = "https://dummyapi.io/data/v1/";
    static String email = "assunta.thiel115@hotmail.com";
    String expectedId = "647d5864fb98426b6b5559a8";

    /** Get List without authentication
     Expected result: Response status error 403 and body with error message 'APP_ID_MISSING'
     */
    @Test
    public void testRequestWithoutAuth() {
        Specifications.installSpecifications(Specifications.requestSpec(UrlDummy), Specifications.responseSpecError403());
        Response response = given()
                .when()
                .get("/comment")
                .then().log().all()
                .body("error", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String errorMsg = jsonPath.get("error");
        System.out.println(errorMsg);
        Assert.assertEquals("APP_ID_MISSING", errorMsg);
    }

    /** Get List of users, page 7, sorted by registration date
     Expected result: Response status 200
     User id is not equal next user id
     */
    @Test
    public void testListOfUsersHasUniqUserId() throws IOException {
        Specifications.installSpecifications(Specifications.requestWithAuth(UrlDummy), Specifications.responseSpecOk200());
        Response response = given()
                .when()
                .get("/user/?page=7")
                .then().log().all()
                .body("data.id", notNullValue())
                .body("data.firstName", notNullValue())
                .body("data.lastName", notNullValue())
                .body("data.picture", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> ids = jsonPath.get("data.id");

        for(int i = 0; i < ids.size() - 1; i++) {
            Assert.assertNotEquals(ids.get(i), ids.get(i+1));
        }
    }

    /** Create User
     Expected result: Response status 200
     Data contains not null value of user id
     */
    @Test
    public void testCreateUser() throws IOException {
        Specifications.installSpecifications(Specifications.requestWithAuth(UrlDummy), Specifications.responseSpecOk200());
        Map<String, String> user = new HashMap<>();
        user.put("email", email);
        user.put("firstName", "Piter");
        user.put("lastName", "Pen");
        Response response = given()
                .body(user)
                .when()
                .post("/user/create")
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String firstName = jsonPath.get("firstName");
        String lastName = jsonPath.get("lastName");
        String id = jsonPath.get("id");

        Assertions.assertEquals("Piter", firstName);
        Assertions.assertEquals("Pen", lastName);
        Assertions.assertFalse(id.isEmpty());
    }

    /** Delete User
     Delete user by id, return id of deleted user
     */
    @Test
    public void testDeleteUser() throws IOException {
        Specifications.installSpecifications(Specifications.requestWithAuth(UrlDummy), Specifications.responseSpecOk200());
        Response response = given()
                .when()
                .delete("/user/" + expectedId)
                .then().log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String id = jsonPath.get("id");
        Assert.assertEquals(expectedId, id);
    }
}


