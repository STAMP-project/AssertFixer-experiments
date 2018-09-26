import {TestBed} from '@angular/core/testing';

import {ActuatorService} from './accurator.service';

describe('AccuratorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ActuatorService = TestBed.get(ActuatorService);
    expect(service).toBeTruthy();
  });
});
