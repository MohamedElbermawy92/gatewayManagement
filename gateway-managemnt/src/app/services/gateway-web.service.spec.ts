import { TestBed } from '@angular/core/testing';

import { GatewayWebService } from './gateway-web.service';

describe('GatewayWebService', () => {
  let service: GatewayWebService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GatewayWebService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
