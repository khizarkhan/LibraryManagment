import { TestBed } from '@angular/core/testing';

import { LiberayServiceService } from './liberay-service.service';

describe('LiberayServiceService', () => {
  let service: LiberayServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LiberayServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
