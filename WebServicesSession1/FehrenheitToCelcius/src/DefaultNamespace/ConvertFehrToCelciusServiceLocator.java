/**
 * ConvertFehrToCelciusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class ConvertFehrToCelciusServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.ConvertFehrToCelciusService {

    public ConvertFehrToCelciusServiceLocator() {
    }


    public ConvertFehrToCelciusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConvertFehrToCelciusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConvertFehrToCelcius
    private java.lang.String ConvertFehrToCelcius_address = "http://localhost:8080/FehrenheitToCelcius/services/ConvertFehrToCelcius";

    public java.lang.String getConvertFehrToCelciusAddress() {
        return ConvertFehrToCelcius_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConvertFehrToCelciusWSDDServiceName = "ConvertFehrToCelcius";

    public java.lang.String getConvertFehrToCelciusWSDDServiceName() {
        return ConvertFehrToCelciusWSDDServiceName;
    }

    public void setConvertFehrToCelciusWSDDServiceName(java.lang.String name) {
        ConvertFehrToCelciusWSDDServiceName = name;
    }

    public DefaultNamespace.ConvertFehrToCelcius getConvertFehrToCelcius() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConvertFehrToCelcius_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConvertFehrToCelcius(endpoint);
    }

    public DefaultNamespace.ConvertFehrToCelcius getConvertFehrToCelcius(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.ConvertFehrToCelciusSoapBindingStub _stub = new DefaultNamespace.ConvertFehrToCelciusSoapBindingStub(portAddress, this);
            _stub.setPortName(getConvertFehrToCelciusWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConvertFehrToCelciusEndpointAddress(java.lang.String address) {
        ConvertFehrToCelcius_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.ConvertFehrToCelcius.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.ConvertFehrToCelciusSoapBindingStub _stub = new DefaultNamespace.ConvertFehrToCelciusSoapBindingStub(new java.net.URL(ConvertFehrToCelcius_address), this);
                _stub.setPortName(getConvertFehrToCelciusWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ConvertFehrToCelcius".equals(inputPortName)) {
            return getConvertFehrToCelcius();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "ConvertFehrToCelciusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "ConvertFehrToCelcius"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConvertFehrToCelcius".equals(portName)) {
            setConvertFehrToCelciusEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
