import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeviceComponent } from './components/device/device.component';
import { GatewayBoardComponent } from './components/gateway-board/gateway-board.component';
import { GatewayComponent } from './components/gateway/gateway.component';

const routes: Routes = [
  {path:"", component: GatewayBoardComponent},
  {path:"gateway/:id", component: GatewayComponent},
  {path:"device", component: DeviceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
