package com.example.sth0409.mylive20.Data;

import com.example.sth0409.mylive20.Entity.Entity_Net;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by STH0409 on 2016/11/1.
 */

public class Data_EntityMsgList {
    /***
     * "告白气球",
     "刚刚好",
     "Faded",
     "Sing Me To Sleep",
     "Sugar",
     "Red",
     "Call Me Maybe",
     "See You Again"
     */
    public Data_EntityMsgList() {
        Host.put("Host","music.163.com");
        entity_netMap.put("告白气球",loadEntity_net1());
        entity_netMap.put("刚刚好",loadEntity_net2());
        entity_netMap.put("Faded",loadEntity_net3());
        entity_netMap.put("Sing Me To Sleep",loadEntity_net4());
        entity_netMap.put("Sugar",loadEntity_net5());
        entity_netMap.put("Red",loadEntity_net6());
        entity_netMap.put("Call Me Maybe",loadEntity_net7());
        entity_netMap.put("See You Again",loadEntity_net8());
    }

    private Entity_Net loadEntity_net1() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_418603077/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "9CMuNnQ5u5DJcisr4BR6YDOPCHZJ+AznENXzkPyx38sn62TXXnXmMhtqaL8kvy6Eevns2IStHuTrQv25+mWnJm0ct2I0rqz5hKFV+PwGk19ECUjcaM6DpjV3qpodFc4fx1+UCGisVx/+KbrRim5UbtQLCKC/hsfBnW1TFEQFzVLfJ6B0DuBDth+n/efxwWRqyRUX4QIn3Om06lP9F7GxXdpTq4QVmN/mcF7II8PNZbU=");
        encSecKey.put("encSecKey", "2704e840a0a4b96fe268805bc7974eeac16058c557c50af2c7ab44b44a3d440c7f86fe47ea031c3a6d989687e98e68e89e81e34e57bd1099166a29d69cee9c57003dce78825ae8c1b77214e81e40bbc64f2cc125de3acfd3489203a212e1d95e00089d93660a6b7c80377c03e7bf9193ebc60ba03d3e7628f04f41b16d27636b");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=418603077");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net3() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_36990266/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "bvpuqcPlXBuqs09QeHr7985dMzf1wZbruyE2yePOXKVmEw5hQ1WpFSTkYAo8TBwM1sWO9CyBRkEnldUDKJpXIuDfqjImaTzX3nSvQ/0xd3W0lx00ETGzvMHRaLu32EqixlKxstWTDRG5iqDk55wAvgPTeZ4jpMGby2Nhob7j56bHM9b970Mc95nWN1h6UTgt3cJxuCPF/NmhXe2dr7bTHEoKDiLv6+aZv2ONsvHWUZM=");
        encSecKey.put("encSecKey", "4f1472cec9fb114299c0f0d65e139fb7e8693ed3bea8c898ab26d39e1ccb17830846e0343d2f8d92eb6e367cf74a7969eae4a7935608966d4a8783710b34b51127866ce15fba3ceedf784d0c7cc4dc7f1abcb1cedc769dafb9759ef5dd6f03ca48e247f232acf2424c63dffbad2d9aaefe905f4b350e17e1ed27145cc872a8a1");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=36990266");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net4() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_415792222/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "bB5NhxJhXCdmI8wvGeTwCaxYrpDsFFMD9nIIwBfVvhkBwSgles4onv4CAVvPvRftE4B64pFyLy3iyo3JkDniP+82RfMFBr2ltLFVPnNkdBbQu1guD6PoTP8ItTdxEY2XY3+cHJBGfcY1b1eq0wk1mPdD4UwEGYQ8MmItss1C5xUjnHE9mFzeKoxHSQHmfPXqubcMD+BG5BaeeyF0057W0+/GDu3lwVOzmUodzw5/VFQ=");
        encSecKey.put("encSecKey", "c7064cb4b7cb10556467e58e45823b37010067b4c4e3e53f0b2448bc5a86c11cf8dd09535327854306becaa40d2be4308ffd1a8334fb9c24ec0345a55d3a19171c2feebca41bbf55b480821440937ee0f013581d77f4c250c3fe1837a2d416f1d300a5c09d386150fa7c0262ef1536fe23b01dd1f0909ddc905df96ae5b48dab");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=415792222");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net5() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_29019227/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "/OCKU8FCNPv32gl588b5UPWGalpVHFHCz+8fbyy8jbkAsvrp/iuvrrk/z3gkNUcra9hV4dVSYjjT/a3GviEGGHnKGStF3CXZXmm1csLxy7PMrfju7FIOy6dUhMnTR+ZsKho4q0/ib75/m/4AXk0fVOTVNBYeSEU/eUQa7XeXxlpA+YQLxCFn+2TFblIQwAKDClTVVKXtMGFqem9qe2U4HXB3NCWG20A/qViGJD+vqOU=");
        encSecKey.put("encSecKey", "aa3fe1e0f0ea7970e6fcf3ab9ad1f198d1d5cd646b1abca6e3febfcd712c8f3df7d7850399d26a8d53287f1fc839b915e09181576b6958f11cec90a253d00f09f04c065438fe7ede98d4bd626c40e5ace7ff5fa9fb88b1a32634be4f3483e0dec5ca34988c1816a4bc335221035c02398766b230db398ace8e76f1ae24dcbd26");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=29019227");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net6() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_19292800/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "IlQ70e2eRhImkjlJQM9/cuGF6hbWSi8wag61/KhlDxw3WazqXfTFpIa1Tio0e0IvVDUNW+jwAOw0d7uNKiqhq3ub1Ec2lmvrimDvncsqJayPBHFIt95bQwk68EuXRkOx1ZWqxbp6rkCSA+eCLI+IniOTBYMmuB6wuRJWY2vbkBuEU+PfaMMyZfJ3jzS5MkmpOOU81R6m8HnrIboTVtwTmW9Rj0shMt7rXeX4qEec8+I=");
        encSecKey.put("encSecKey", "31c587644142446a340dc81356078a6303a25e36ef45ecd4e05bd263636ed8bdaafbaf517c2ca5de8ab15a888ccd8b0fdb2589edb08c372e7f746d457222d8231097db6c64c842996354bc152af588c1ff239e78cb72f6f6363b8fab0010e1655a5325267a7b51632e0a4aa4e0a231950093493f496e383a94d60ae090e45d8f");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=19292800");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net7() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_17112299/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "Sla0ee7kNPXPaT6bP/Hz7lKmdyjwX6dv3AzIFjYQlPvjdfFfwHpVBcihLDmp6kHiVOHCKAD6IaGJXhgrRVBPr/WLHVDg8EKYhShFjIYkkuDcsWcKTFWL2Bv4riSELl207iaMDfX8klkswmm0LBNB/fT7Wn3NEzVvtDbAP+wy/b8DNoiZ9D/9Urz1Hm3HV/LpYgduRuqcwznNkUaCdbzwvo6mZzCdAlWbUrIOC3FZPAY=");
        encSecKey.put("encSecKey", "9911ca0bef91ead21fac0a9f953b524819bef5dcf83657d64799b07ccce6b55cbc9238d7beb2c8b4868515a49da8e28a31695167205523341d3edaf8cfd8d22e330813e757a168680ef6e2bcd0342f79b2e67c83172dedf9a07dd00d3ea373ca9d969dd5d477a09a3f5e4d5aec4579e4f795299bcaf077b23f870d745a6183d2");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=17112299");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net8() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_30953009/?csrf_token=c82c05934a929251d11bf8aed801440d");
        params.put("params", "jwa0f+3IUJPd0PUOV1fFt1OPKvuaFfuOcY0Co2sPanKn7zvFNCfGwlQosjb6c3xV/9yCxlgtQfVMXoA4UlgWPCQPbSyKtjFuDkU00G/9lL8EyasyYuvyFHgHHyY0Rhi2tmbYfQf0/Rq6UTk4jWavK7tK4WiH5CnEAOygCArLXjf8fwShbwQZN/nNRIdQeV2uPH4P6M7TzcFEszmzbRj9GFib57elrM+hAG+WLanNaQo=");
        encSecKey.put("encSecKey", "329c024b272b071fa713bd0a0664c7c115a6b97b0d8db55ccebc0df1e2ff167dd0871c9d2b486c8a355d9935a098bff6561c6bf70438c525102f1b6baff89ac2d419fbfcd9eab440be315a26b7163a0f9a1b42dcb4d87861aa1ce5c2d8d4a4054fd18377310d64e3c551a4354981a1240669b5a826bae946388af5be90b97744");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=30953009");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }
    private Entity_Net loadEntity_net2() {
        Map<String, String> Url = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> encSecKey = new HashMap<>();
        Map<String, String> csrf_token = new HashMap<>();
        Map<String, String> Referer = new HashMap<>();
        Url.put("url", "http://music.163.com/weapi/v1/resource/comments/R_SO_4_415792881/?csrf_token=9637402056ffae882589e788492978c4");
        params.put("params", "DD+ELOPYH/G9uZrx56JYQYazFPneF05hJxnaL+L2jhYuCjPqj00kSzsWb6jvqEyNN0JjPg4JKKX2yzfEiy69Oxdrzdlro3mJ7paxylomMAWN0agpgjmMqZSjOn2p+iGhQPaiTmyy0ZfRfFH00WWRUdVzjdDoeQM9uFKtpF50H0L4G1RGPn7XiHO2kTWBgQ6YcrbvOSatIdQFwFtr99wSxoPP8Sq+GHOEuuRHwLoIUnE=");
        encSecKey.put("encSecKey", "795ad1a78cc9244cbb4c8447be2147f9401b0ae640cc6564d3f371628fa30a12db6f37e3ec8b6c1c200e25101cd0790fa135386d761671381fb7004aa92a28378c1bfa25b0c4abd1faafb38ad09ed0d75ab4c75c065448885ce011c59d3e49b9ceeb2862f134d79ce231803f3dfb6d9f08f212405a7b6242e286c1c0ea91481f");
        csrf_token.put("csrf_token", "c82c05934a929251d11bf8aed801440d");
        Referer.put("Referer","http://music.163.com/song?id=415792881");
        return new Entity_Net(Url,params,encSecKey,csrf_token,Host,Referer);
    }



    public Map<String, Entity_Net> getEntity_netMap() {
        return entity_netMap;
    }
/*

 */
    private Map<String, Entity_Net> entity_netMap=new HashMap<>();

    private Map<String, String> Host = new HashMap<>();

}
