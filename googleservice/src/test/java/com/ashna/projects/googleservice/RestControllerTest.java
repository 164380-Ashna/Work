package com.ashna.projects.googleservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/*
@RunWith(SpringJUnit4ClassRunner.class)
public class RestControllerTest {
	
	private MockMvc mvc;
	
	@InjectMocks
	private GoogleserviceApplication googleserviceapplication;
	
	@Before
	public void setUp() throws Exception {
		mvc= MockMvcBuilders.standaloneSetup(googleserviceapplication)
				.build();
	}

	@Test
	public void testRestController() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/user"))
		
	}*/

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = GoogleserviceApplication.class)
public class RestControllerTest {
 
    @Autowired
    private GoogleserviceApplication gsa;
 
    @Autowired
    private WebSecurityConfiguration wsc;
    
    @Autowired
    private WebApplicationContext wac;
 
    @Autowired
    private FilterChainProxy springSecurityFilterChain;
 
    private MockMvc mvc;
 
    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac)
         // .addFilter(springSecurityFilterChain)
          .build();
    }
    
	/*
	 * private String obtainAccessToken(String username, String password) throws
	 * Exception {
	 * 
	 * MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	 * params.add("grant_type", "user"); params.add("client_id",
	 * "155927313277-ok5d5f1s9a8im2osebem82loe75f62oa.apps.googleusercontent.com");
	 * params.add("username", "vijaykumarsaw.saw@gmail.com"); params.add("password",
	 * "naughtyguys");
	 * 
	 * ResultActions result = mvc.perform(post("/oauth/token") .params(params)
	 * .with(httpBasic(
	 * "155927313277-ok5d5f1s9a8im2osebem82loe75f62oa.apps.googleusercontent.com",
	 * "Z1wKwrVG0j-YIJCubNiocPo-")) .accept("application/json;charset=UTF-8"))
	 * .andExpect(status().isOk())
	 * .andExpect(content().contentType("application/json;charset=UTF-8"));
	 * 
	 * String resultString = result.andReturn().getResponse().getContentAsString();
	 * 
	 * JacksonJsonParser jsonParser = new JacksonJsonParser(); return
	 * jsonParser.parseMap(resultString).get("access_token").toString(); }
	 * 
	 * 
	 * @Test public void testLogin() throws Exception { RequestBuilder
	 * requestBuilder =
	 * formLogin().user("vijaykumarsaw.saw@gmail.com").password("naughtyguys");
	 * mvc.perform(requestBuilder).andExpect(redirectedUrl("/user")).andExpect(
	 * status().isFound()); }
	 */
    
    @Test
    public void testMyRedirect() throws Exception {
     mvc.perform((RequestBuilder) ((ResultActions) post("/me"))
      .andExpect(status().isOk())
      .andExpect(redirectedUrl("/oauth2/auth")));
  }
}


