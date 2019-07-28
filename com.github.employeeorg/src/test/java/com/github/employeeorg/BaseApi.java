package com.github.employeeorg;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.employeeorg.BaseModel;
import com.google.gson.Gson;

/**
 * @author Sundareswari Sundaramahalingam THIS CLASS IS TO PROVIDE METHODS FOR
 *         ACHEIVING HTTP REQUEST AND RESPONSE FOLLOWING JERSEY FRAMEWORK
 *         VALIDATING THE RESPONSE CODE IS HANDLED IN THIS CLASS
 */
public class BaseApi {
	private Response response = null;
	private Object returnObject = null;
	private Gson gson = null;
	private Client client = null;
	WebTarget webTarget = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseApi.class);

	public BaseApi() {
		gson = new Gson();
		client = ClientBuilder.newClient();
	}

	/**
	 * GET method for sending the request and receiving JSONArray in request this
	 * method response JSONArray as string
	 * 
	 * @param url
	 * @param token
	 * @return
	 */
	public String get(String url, String token) {
		webTarget = client.target(url);
		LOGGER.info("url **** : " + url);

		if (token == null) {
			// API is public and doesn't need authentication
			response = webTarget.request("application/json").get();
		} else {
			// for API which needs auth token
			response = webTarget.request("application/json").header("authorization", token).get();
		}

		String raw = response.readEntity(String.class);

		LOGGER.info("response json **** : " + raw);
		if (response.getStatus() == 200) {
			return raw;

		} else {
			LOGGER.error("Got status code: " + response.getStatus() + " while converting response: " + raw);

		}
		return raw;
	}

	/**
	 * POST method for sending the request with body and receiving JSONOBJECT in
	 * request this method response JSONOBJECT as Object
	 * 
	 * @param url
	 * @param body
	 * @return
	 */
	public Object post(String url, BaseModel body) {
		webTarget = client.target(url);
		LOGGER.info("url **** :" + url);
		LOGGER.info("request json **** :" + gson.toJson(body));

		response = webTarget.request().post(Entity.json(gson.toJson(body)));

		String raw = response.readEntity(String.class);

		LOGGER.debug("response json **** : " + raw);

		if (response.getStatus() == 200) {
			LOGGER.debug("response status: " + response.getStatus());
			returnObject = gson.fromJson(raw, body.getClass());
			LOGGER.info("return Object **** : " + returnObject.toString());
		} else {
			LOGGER.error("Got error while converting response: " + raw);
		}

		return returnObject;
	}

	/**
	 * PUT method for sending the request for updating URI with body and
	 * receiving JSONOBJECT in request this method response JSONOBJECT as Object
	 * @param url
	 * @param token
	 * @param body
	 * @return
	 */
	public Object put(String url, String token, BaseModel body) {
		webTarget = client.target(url);
		LOGGER.info("url **** : " + url);
		LOGGER.info("request json **** : " + gson.toJson(body));
		response = webTarget.request("application/json").header("authorization", token)
				.put(Entity.json(gson.toJson(body)));

		String raw = response.readEntity(String.class);

		LOGGER.debug("response json **** : " + raw);
		if (response.getStatus() == 200) {
			LOGGER.debug("response status: " + response.getStatus());
			returnObject = gson.fromJson(raw, body.getClass());
			LOGGER.info("return Object **** : " + returnObject.toString());
		} else {
			LOGGER.info("Got error while converting response: " + raw);
		}
		return returnObject;
	}

	/**
	 * DELETE method for sending request and deleting content from URI
	 * @param token
	 * @param url
	 * @return
	 */
	public String delete(String token, String url) {
		webTarget = client.target(url);
		LOGGER.info("url **** : " + url);
		response = webTarget.request("application/json").header("authorization", token).delete();

		String raw = response.readEntity(String.class);

		LOGGER.info("response json **** : " + raw);
		if (response.getStatus() != 200) {
			LOGGER.info("Got status code: " + response.getStatus() + " while deleting enitity: " + url);
		}
		return raw;
	}
}
