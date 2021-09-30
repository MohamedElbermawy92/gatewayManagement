import { Component, OnInit } from '@angular/core';
import { Gateway } from 'src/app/models/gateway';
import { GatewayWebService } from 'src/app/services/gateway-web.service';

@Component({
  selector: 'app-gateway-board',
  templateUrl: './gateway-board.component.html',
  styleUrls: ['./gateway-board.component.css']
})
export class GatewayBoardComponent implements OnInit {
  gateWays: Gateway[] = [];
  constructor(private gatewayWebService: GatewayWebService) { }

  ngOnInit(): void {
   this.getData();
  }

  onAdd(gateWay: Gateway){
    console.log(gateWay);
    this.gatewayWebService.saveGateWay(gateWay)
    .subscribe((res)=> {
      console.log("on save success ", res);
      this.getData();
    });
  }

  getData(){
    this.gatewayWebService.getAllGateways().subscribe(data =>{
      console.log("data : ", data);
      this.gateWays = data;
    })
  }

  onRemove(gateWay: Gateway){
    console.log(gateWay);
    this.gatewayWebService.removeGatewayById(gateWay.id).subscribe(d=>{this.getData()}, err=>{}, ()=>{
      this.getData();
    })
  }
}
