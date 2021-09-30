import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Device } from '../models/device';
import { Gateway } from '../models/gateway';

@Injectable({
  providedIn: 'root'
})
export class GatewayWebService {
  readonly URL = "http://localhost:8081/api/findallgateway"
  constructor(private httpClient: HttpClient) { }

  getAllGateways(){
    return this.httpClient.get<any>(this.URL);
  }

  getAllDevicesByGetwayID(getwayID: number){
    return this.httpClient.get<any>("http://localhost:8081/api/findgateway/"+getwayID);
  }

  saveGateWay(gateWay: Gateway){
    return this.httpClient.post("http://localhost:8081/api/addGateway", gateWay);
  }

  addDeviceToGateway(getwayID: number, device: Device){
    return this.httpClient.post("http://localhost:8081/api/addDevice", {id: getwayID, device: device});
  }

  removeGatewayById(gateWayID: number){
    return this.httpClient.delete("http://localhost:8081/api/deletegateway/"+gateWayID);
  }
}
