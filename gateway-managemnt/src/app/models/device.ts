import { DeviceStatus } from "./device-status-enum";

export class Device{
    UID: number;
    vendor: string;
    date: Date |string;
    status: DeviceStatus;
}