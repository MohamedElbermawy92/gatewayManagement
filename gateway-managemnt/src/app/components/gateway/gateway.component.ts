import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Device } from 'src/app/models/device';
import { GatewayWebService } from 'src/app/services/gateway-web.service';

@Component({
  selector: 'app-gateway',
  templateUrl: './gateway.component.html',
  styleUrls: ['./gateway.component.css']
})
export class GatewayComponent implements OnInit {
  gateWayid: number = 1;
  devices: Device[] = [];
  constructor(private gatewayWebService: GatewayWebService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      this.gateWayid = parseInt( params.get('id'));
      console.log(params.get('id'));
      this.getData(this.gateWayid);
    })
  }

  addDeviceToGateway(devie: Device) {
    this.gatewayWebService.addDeviceToGateway(this.gateWayid, devie)
    .subscribe(s => { this.getData(this.gateWayid)}, err => { }, () => {
      this.getData(this.gateWayid)
    })
  }

  getData(id: number) {
    this.gatewayWebService.getAllDevicesByGetwayID(id).subscribe(data => {
      console.log("data");
      this.devices = data;
    })
  }
}
