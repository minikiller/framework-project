package com.restfulapi.test;

import javax.ws.rs.core.MediaType;

import com.jcj.rest.http.fluent.APIResponse;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jcj.rest.general.helper.APITest;
import com.jcj.rest.http.fluent.APIRequest;

/**
 * 
 * Demo about how to use this framework
 * 
 * Need store some some APIs configuration in a env.properties files
 * 
 * @author Carl Ji
 *
 */
public class HTTPRequestsTest extends APITest {
	private String token ;

	/**
	 * return json format is :{success:true,location:'/kalix/index.jsp',message:'登入成功',
	 * user:{name:'管理员',token:'70841dfd-97f3-43e3-b1d9-dded905d9f73'}}
	 */
	@Before
	public void login(){
		String uri = getValue("login.uri");
		APIResponse response= APIRequest.POST(uri).param("username","admin").param("password","123").invoke();
		String returnString=response.getBody(String.class);
		JSONObject jsonObject = new JSONObject(returnString);
		JSONObject user=jsonObject.getJSONObject("user");
		token= (String) user.get("token");
		Assert.assertNotNull(token);
	}

	/**
	 * test for add new Entity method
	 */
	@Test
	public void testHttpPOSTRequest()
	{
		String uri = getValue("post.uri");
		String payload = loadFile("add.json");
		APIResponse response=APIRequest.POST(uri).header("Cookie", "JSESSIONID="+token).type(MediaType.APPLICATION_JSON_TYPE).body(payload)
				.invoke().assertStatus(200);
		String returnString=response.getBody(String.class);
		JSONObject jsonObject = new JSONObject(returnString);
		Assert.assertNotNull(jsonObject);
	}

	/**
	 * test for getAll method
	 */
	@Test
	public void testHttpGETRequest()
	{
		String uri = getValue("get.uri");
		APIResponse response=APIRequest.GET(uri).header("Cookie", "JSESSIONID="+token).param("page","1").param("limit","10")
	    .invoke().assertStatus(200);
		String returnString=response.getBody(String.class);
		JSONObject jsonObject = new JSONObject(returnString);
		Assert.assertNotNull(jsonObject);
	}

	
	@Test
	public void testHttpPUTRequest()
	{
		String uri = getValue("put.uri");
		String token = getValue("put.token");
		String payload = loadFile("xmlfile.xml");
		
		
	    APIRequest.PUT(uri).header("Authorization", "Bearer " + token).type(MediaType.APPLICATION_XML_TYPE).body(payload)
	    .invoke().assertStatus(204);
	}
	
	@Test
	public void testHttpDELETERequest()
	{
		String uri = getValue("delete.uri");;
		String token = getValue("delete.token");; 
		String payload = String.format(loadFile("update.json"), "1783a8eb18109f7f6386c4187e42e06c4ca32f8b2c0101ce3a281dcc06edec8e","029c14ffe730dd784b2eff76badc54ab516b4ec0fedb12f35e01894b4916a7fd");
		
	    APIRequest.DELETE(uri).header("Authorization", "Bearer " + token).type(MediaType.APPLICATION_JSON_TYPE).body(payload)
	    .invoke().assertStatus(200);
	}

}
