import { Component, OnInit } from '@angular/core';
import { SSO_URL } from 'app/app.constants';

@Component({ selector: 'jhi-login', templateUrl: './login.component.html' })
export class LoginComponent implements OnInit {
    constructor() {}
    ngOnInit(): void {
        window.location.replace(SSO_URL);
    }
}
