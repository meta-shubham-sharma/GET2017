package DefaultNamespace;

public class ConvertFehrToCelciusProxy implements DefaultNamespace.ConvertFehrToCelcius {
  private String _endpoint = null;
  private DefaultNamespace.ConvertFehrToCelcius convertFehrToCelcius = null;
  
  public ConvertFehrToCelciusProxy() {
    _initConvertFehrToCelciusProxy();
  }
  
  public ConvertFehrToCelciusProxy(String endpoint) {
    _endpoint = endpoint;
    _initConvertFehrToCelciusProxy();
  }
  
  private void _initConvertFehrToCelciusProxy() {
    try {
      convertFehrToCelcius = (new DefaultNamespace.ConvertFehrToCelciusServiceLocator()).getConvertFehrToCelcius();
      if (convertFehrToCelcius != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)convertFehrToCelcius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)convertFehrToCelcius)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (convertFehrToCelcius != null)
      ((javax.xml.rpc.Stub)convertFehrToCelcius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.ConvertFehrToCelcius getConvertFehrToCelcius() {
    if (convertFehrToCelcius == null)
      _initConvertFehrToCelciusProxy();
    return convertFehrToCelcius;
  }
  
  public double convertTemperature(double input) throws java.rmi.RemoteException{
    if (convertFehrToCelcius == null)
      _initConvertFehrToCelciusProxy();
    return convertFehrToCelcius.convertTemperature(input);
  }
  
  
}