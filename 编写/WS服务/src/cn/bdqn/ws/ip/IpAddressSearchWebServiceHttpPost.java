package cn.bdqn.ws.ip;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.4
 * 2016-03-11T12:33:10.529+08:00
 * Generated source version: 2.7.4
 * 
 */
@WebService(targetNamespace = "http://WebXml.com.cn/", name = "IpAddressSearchWebServiceHttpPost")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IpAddressSearchWebServiceHttpPost {

    /**
     * <br /><h3>通过输入IP地址查询国家、城市�?�?��者等信息。没有注明国家的为中�?/h3><p>输入参数：IP地址（自动替�?" �? �?"."），返回数据�?�?���?��字符串数组String(1)，String(0) = IP地址；String(1) = 查询结果或提示信�?/p><br />
     */
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    @WebMethod
    public ArrayOfString getCountryCityByIp(
        @WebParam(partName = "theIpAddress", name = "theIpAddress", targetNamespace = "http://WebXml.com.cn/")
        java.lang.String theIpAddress
    );

    /**
     * <br /><h3>获得本IP地址搜索 WEB 服务的数据库版本更新时间</h3><p>输入参数：无，输出参�?String</p><br />
     */
    @WebResult(name = "string", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    @WebMethod
    public java.lang.String getVersionTime();

    /**
     * <br /><h3>获得您的IP地址和地�?���?/h3><p>输入参数：无，返回数据： �?���?��字符串数组String(1)，String(0) = IP地址；String(1) = 地址信息</p><br />
     */
    @WebResult(name = "ArrayOfString", targetNamespace = "http://WebXml.com.cn/", partName = "Body")
    @WebMethod
    public ArrayOfString getGeoIPContext();
}
