package com.xuecheng.orders;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.AlipayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mr.M
 * @version 1.0
 * @description 支付宝查询接口
 * @date 2022/10/4 17:18
 */
@SpringBootTest
public class AliPayTest {

    @Value("${pay.alipay.APP_ID}")
    String APP_ID;
    @Value("${pay.alipay.APP_PRIVATE_KEY}")
    String APP_PRIVATE_KEY;

    @Value("${pay.alipay.ALIPAY_PUBLIC_KEY}")
    String ALIPAY_PUBLIC_KEY;

    /*@Test
    public void queryPayResult() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, APP_ID, APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE); //获得初始化的AlipayClient
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "202308100010102999");
        bizContent.put("trade_no", "2023081922001461290500680974");
        request.setBizContent(bizContent.toString());
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        // AlipayTradeQueryResponse response = alipayClient.execute(request);
        boolean success = response.isSuccess();
        if (success) {
            System.out.println("调用成功");
            String resultJson = response.getBody();
            //转map
            Map resultMap = JSON.parseObject(resultJson, Map.class);
            Map alipay_trade_query_response = (Map) resultMap.get("alipay_trade_query_response");
            //支付结果
            String trade_status = (String) alipay_trade_query_response.get("trade_status");
            System.out.println(trade_status);
        } else {
            System.out.println("调用失败");
        }
    }*/

    @Test
    public void testQuery() throws AlipayApiException {
        String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDOL4qT15jc+RFoMoPmjx28xGJ7LvQd/247hfz6EtH53kf6H69RBJvldCsKwfRX5tbfm0P+zW6xk3vAQ9df0BDOoH1QqSP+zBH/VPP1upderz1kq7lUVSNds7qlOj+QHT8RaLgeyU9hb5CORXqv/6hDO2OapC1kQm/pWt81LT9gUotxnIDc0XWMJwrYB9ploBICjWYH9W1aPwqn/hElegodcgcO0MlUrJ1MOffqqsKAPaTF2elo0vahJo1ghPhVwQGPL2EPnBFyo/UfzUCeQOlCwrnyaw9ER7OdfgO1wfhMJ0/Zx9s2yZyGylhUib2mbQG4Jd+rAKOAzw675Alyfh7JAgMBAAECggEAc6aG/FY6D/hEo0VyZqhv7anZ825qz0iu9AQ72akkzhq4FLwhAjirmRCH9AjGnWeFrvbQNOPV6xTmnPlwnPV/9+ZdZBj7b7fXgHiOPo7iyOFSdl08HumCZNSjJHp/nL5K2eD7JYmVVPnXA3ZFUuL75noxbFQagdoiG6o0+QbgPY4NfaW8H7a8Q8NKSGLxBpSe/diLv54HIz2aHHDQMYw4J2ZmOhPAbvFnOPi+ledBIXvhTrIDUUxG0J2wlTh2vB5umP+iIG7F2sMDchdMq0gxVjWqbNGy5Kw4edH/ddv8D+iSfnxRSYPKI3I2VhkHKHKxN/ApinfiV9hFCZx7L4Y4YQKBgQDs606/o/89XQORpvgkyNcEkCmDzsadyodfhTcngZKXLwbGPhZfPIcSkez90AMFJURKAx6T5fnwqw6p4oG1b9ciYC76MtfgYvzC38bWEQBqzmQHn5YHVj52Zbj5wgyHhw/KFkJvBNtUFztkUcZ8bDp2XWz8ptL03Mp/kX/yzkHfawKBgQDeypXHbICvHQj3vtBarb0JFYUwVNwWB3eBgRQK4mIPkgBppkLkpMC28nWYOezUhtc9KMY9XUzZaap14pEiVHekTJjr52a3tUfwpAKi6kIiGA+Uf/yIhrH1Bx2AdDbKxkkIzoE+6mp/NOsW8MWdJJ+sinVaR2nuCy35ux8/89bLmwKBgBfwVs6qZXnv0hJ/ioc8++zsHCXDWPJMqo0OStplD0jTaZ3SXDRXS1anBAlJYWS9tT69PfO3wx98SUkFKBILMPO6QETrqkB0ABI4xkCPCzm/jP/wMhqfrkQMVzp1TwrKrN/AjAnntbmzdz7VvHaKAQZAvmhw+tPfE178dq80BBftAoGBAJq+e2oYowj+UcxCbNWO903n9KqtRnDGnusEjLdCpnnKHx9CrBPDm1d28Nba5PR48+c2+vqEY2xfSFa5F7WQlck4qr6v61iOQXmTcYFW1Lh5ndi3TOBHLjPSzVr7XVNahj/nrz3T9ESGrQMyGRAc8AsX4IrkL193xGdA4WO6KechAoGBAN/Wb8h6OUaMgWLjW5B6msj2/1/AuQ2h5e0hM2J8TeGrJZ9hyp3SlOe9ysXaV2dGaiNelmL+cdQ7sm99BCOMjKHJRbSjYUPCdqEl3QkFYPoGtVuZpv4Hw1aRQZ1OpAZ/sjfNdGFOx12TUH6PEeiA0JVcywgt7E9yRx95r5wWdpPU";
        String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiOa720k6Q6PW31qo1mB+0ULRmGWQDmfDyIf/bw4BiqrlmW6C67om0pyms5vky4aopOE5n/qgJ/pNcioDzURRQ2KmtJ1OQ9VaCiBT1Q9UXnO8EjgP6xjVSoywKVgfE0M/cIRNrQtZ3r4WGyBn3LjyibdUENzf2zVHToW2MA5kRo1ee4Fmih7unPnXQ/bTPlHoKZs64wsgQ5wEjLn08LHFPb4VUJXT0cCbasnr2HKPXWmE3op/oTekrstPMe8D+NTGTPPqmcovitTEuBASFnNlLcfFRmkFzbzc7kPG54GFhrw+HiGSz5KvYQD2CN0e6XNXgnDAZpN3p6ZL2Pmnc1vCJQIDAQAB";
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
        alipayConfig.setAppId("9021000125670090");
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF8");
        alipayConfig.setSignType("RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig);

        // AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL, APP_ID, APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE); //获得初始化的AlipayClient
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo("202308100010102999");
        model.setTradeNo("2023081922001461290500680974");
        request.setBizModel(model);
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        System.out.println(response.getBody());
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
            // sdk版本是"4.38.0.ALL"及以上,可以参考下面的示例获取诊断链接
            // String diagnosisUrl = DiagnosisUtils.getDiagnosisUrl(response);
            // System.out.println(diagnosisUrl);
        }
    }
}
