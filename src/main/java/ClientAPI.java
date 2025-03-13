import io.restassured.response.Response;
import model_api.AuthorizationUser;
import model_api.CreateNewUser;
import model_api.User;

import static io.restassured.RestAssured.given;

public class ClientAPI {

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String END_URI_CREATE_NEW_USER = "/api/auth/register"; //эндпоинт создания нового пользователя
    private static final String END_URI_DELETE_USER = "/api/auth/user";//эндпоинт удаления пользователя
    private static final String END_URI_AUTHORIZATION_USER = "/api/auth/login";//эндпоинт авторизации пользователя

    //Отправка запроса на создание нового пользователя"
    public Response createNewUser(String email, String password, String name){
        CreateNewUser createNewUser = new CreateNewUser(email, password, name);
        return given().baseUri(BASE_URI).header("Content-type", "application/json").body(createNewUser).post(END_URI_CREATE_NEW_USER); //запрос на создание нового пользователя
    }

    //Отправка запроса на удаление пользователя
    public void deleteUser(String email, String password) {
        AuthorizationUser authorizationUser = new AuthorizationUser(email, password);
        Response response = given().baseUri(BASE_URI).header("Content-type", "application/json").body(authorizationUser).post(END_URI_AUTHORIZATION_USER); //запрос на авторизацию пользователя
        User user = response.body().as(User.class); //десериализация ответа в объект
        String accessToken = user.getAccessToken(); //получение accessToken
        given().baseUri(BASE_URI).header("Authorization", accessToken).delete(END_URI_DELETE_USER); //запрос на удаление пользователя
    }
}