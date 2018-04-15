import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class xueqiu {
    @Test
    public void  testSearch(){
//        useRelaxedHTTPSValidation();

        given()
                .log().all()
                .queryParam("code","sogo")
                .header("Cookie","xq_a_token=229a3a53d49b5d0078125899e528279b0e54b5fe; xq_a_token.sig=oI-FfEMvVYbAuj7Ho7Z9mPjGjjI; xq_r_token=8a43eb9046efe1c0a8437476082dc9aac6db2626; xq_r_token.sig=Efl_JMfn071_BmxcpNvmjMmUP40; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523679356; __utmc=1; __utmz=1.1523679357.1.1.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; u=901523679358595; device_id=41d063cb33a4887c1847cc01ba5a4327; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523687579; __utma=1.506488706.1523679357.1523679357.1523687580.2")
                .when().get("https://xueqiu.com/stock/search.json")
                .then().log().all()
                .statusCode(200)
                .body("stocks.name", hasItems("搜狗"))
                .body("stocks.code",hasItems("SOGO"))
                .body("stocks.find {it.code =='SOGO'}.stock_id", equalTo(1029472))
        ;
    }

}
