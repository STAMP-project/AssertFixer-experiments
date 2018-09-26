(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {

  /***/ "./node_modules/webpack/hot sync ^\\.\\/log$":
  /*!*************************************************!*\
    !*** (webpack)/hot sync nonrecursive ^\.\/log$ ***!
    \*************************************************/
  /*! no static exports found */
  /***/ (function (module, exports, __webpack_require__) {

    var map = {
      "./log": "./node_modules/webpack/hot/log.js"
    };


    function webpackContext(req) {
      var id = webpackContextResolve(req);
      return __webpack_require__(id);
    }

    function webpackContextResolve(req) {
      var id = map[req];
      if (!(id + 1)) { // check for number or string
        var e = new Error("Cannot find module '" + req + "'");
        e.code = 'MODULE_NOT_FOUND';
        throw e;
      }
      return id;
    }

    webpackContext.keys = function webpackContextKeys() {
      return Object.keys(map);
    };
    webpackContext.resolve = webpackContextResolve;
    module.exports = webpackContext;
    webpackContext.id = "./node_modules/webpack/hot sync ^\\.\\/log$";

    /***/
  }),

  /***/ "./src/$$_lazy_route_resource lazy recursive":
  /*!**********************************************************!*\
    !*** ./src/$$_lazy_route_resource lazy namespace object ***!
    \**********************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    function webpackEmptyAsyncContext(req) {
      // Here Promise.resolve().then() is used instead of new Promise() to prevent
      // uncaught exception popping up in devtools
      return Promise.resolve().then(function () {
        var e = new Error("Cannot find module '" + req + "'");
        e.code = 'MODULE_NOT_FOUND';
        throw e;
      });
    }

    webpackEmptyAsyncContext.keys = function () {
      return [];
    };
    webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
    module.exports = webpackEmptyAsyncContext;
    webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

    /***/
  }),

  /***/ "./src/app/app.component.css":
  /*!***********************************!*\
    !*** ./src/app/app.component.css ***!
    \***********************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = ""

    /***/
  }),

  /***/ "./src/app/app.component.html":
  /*!************************************!*\
    !*** ./src/app/app.component.html ***!
    \************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = "<bs-navigation></bs-navigation>\n"

    /***/
  }),

  /***/ "./src/app/app.component.ts":
  /*!**********************************!*\
    !*** ./src/app/app.component.ts ***!
    \**********************************/
  /*! exports provided: AppComponent */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
      return AppComponent;
    });
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };

    var AppComponent = /** @class */ (function () {
      function AppComponent() {
        this.title = 'ng-portfolio-web';
      }

      AppComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
          selector: 'app-root',
          template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
          styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
      ], AppComponent);
      return AppComponent;
    }());


    /***/
  }),

  /***/ "./src/app/app.module.ts":
  /*!*******************************!*\
    !*** ./src/app/app.module.ts ***!
    \*******************************/
  /*! exports provided: AppModule */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "AppModule", function () {
      return AppModule;
    });
    /* harmony import */
    var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    /* harmony import */
    var _app_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
    /* harmony import */
    var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
    /* harmony import */
    var _navigation_navigation_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./navigation/navigation.component */ "./src/app/navigation/navigation.component.ts");
    /* harmony import */
    var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
    /* harmony import */
    var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
    /* harmony import */
    var _error_page_error_page_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./error-page/error-page.component */ "./src/app/error-page/error-page.component.ts");
    /* harmony import */
    var _home_page_home_page_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./home-page/home-page.component */ "./src/app/home-page/home-page.component.ts");
    /* harmony import */
    var _app_routing_module__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.routing.module */ "./src/app/app.routing.module.ts");
    /* harmony import */
    var _currency_currency_page_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./currency/currency-page.component */ "./src/app/currency/currency-page.component.ts");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };


    var AppModule = /** @class */ (function () {
      function AppModule() {
      }

      AppModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
          declarations: [
            _app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"],
            _navigation_navigation_component__WEBPACK_IMPORTED_MODULE_4__["NavigationComponent"],
            _error_page_error_page_component__WEBPACK_IMPORTED_MODULE_7__["ErrorPageComponent"],
            _home_page_home_page_component__WEBPACK_IMPORTED_MODULE_8__["HomePageComponent"],
            _currency_currency_page_component__WEBPACK_IMPORTED_MODULE_10__["CurrencyPageComponent"]
          ],
          imports: [
            _app_routing_module__WEBPACK_IMPORTED_MODULE_9__["AppRoutingModule"],
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_3__["BrowserAnimationsModule"],
            _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_5__["LayoutModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatToolbarModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatButtonModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatSidenavModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatIconModule"],
            _angular_material__WEBPACK_IMPORTED_MODULE_6__["MatListModule"]
          ],
          providers: [],
          bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_2__["AppComponent"]]
        })
      ], AppModule);
      return AppModule;
    }());


    /***/
  }),

  /***/ "./src/app/app.routing.module.ts":
  /*!***************************************!*\
    !*** ./src/app/app.routing.module.ts ***!
    \***************************************/
  /*! exports provided: AppRoutingModule */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
      return AppRoutingModule;
    });
    /* harmony import */
    var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    /* harmony import */
    var _error_page_error_page_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./error-page/error-page.component */ "./src/app/error-page/error-page.component.ts");
    /* harmony import */
    var _home_page_home_page_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./home-page/home-page.component */ "./src/app/home-page/home-page.component.ts");
    /* harmony import */
    var _currency_currency_page_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./currency/currency-page.component */ "./src/app/currency/currency-page.component.ts");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };


    /**
     * Route Definition of the application and link to Component
     */
    var routes = [
      {path: '', component: _home_page_home_page_component__WEBPACK_IMPORTED_MODULE_3__["HomePageComponent"]},
      {
        path: 'currency',
        component: _currency_currency_page_component__WEBPACK_IMPORTED_MODULE_4__["CurrencyPageComponent"]
      },
      {
        path: '**',
        component: _error_page_error_page_component__WEBPACK_IMPORTED_MODULE_2__["ErrorPageComponent"],
        data: {error: 404}
      }
    ];
    /**
     * Separate NgModule declaration for routing
     */
    var AppRoutingModule = /** @class */ (function () {
      function AppRoutingModule() {
      }

      AppRoutingModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes)],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"]]
        })
      ], AppRoutingModule);
      return AppRoutingModule;
    }());


    /***/
  }),

  /***/ "./src/app/currency/currency-page.component.css":
  /*!******************************************************!*\
    !*** ./src/app/currency/currency-page.component.css ***!
    \******************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = ""

    /***/
  }),

  /***/ "./src/app/currency/currency-page.component.html":
  /*!*******************************************************!*\
    !*** ./src/app/currency/currency-page.component.html ***!
    \*******************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = "<p>\n  currency-page works!\n</p>\n"

    /***/
  }),

  /***/ "./src/app/currency/currency-page.component.ts":
  /*!*****************************************************!*\
    !*** ./src/app/currency/currency-page.component.ts ***!
    \*****************************************************/
  /*! exports provided: CurrencyPageComponent */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "CurrencyPageComponent", function () {
      return CurrencyPageComponent;
    });
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (undefined && undefined.__metadata) || function (k, v) {
      if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };

    var CurrencyPageComponent = /** @class */ (function () {
      function CurrencyPageComponent() {
      }

      CurrencyPageComponent.prototype.ngOnInit = function () {
      };
      CurrencyPageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
          selector: 'bs-currency-page',
          template: __webpack_require__(/*! ./currency-page.component.html */ "./src/app/currency/currency-page.component.html"),
          styles: [__webpack_require__(/*! ./currency-page.component.css */ "./src/app/currency/currency-page.component.css")]
        }),
        __metadata("design:paramtypes", [])
      ], CurrencyPageComponent);
      return CurrencyPageComponent;
    }());


    /***/
  }),

  /***/ "./src/app/error-page/error-page.component.css":
  /*!*****************************************************!*\
    !*** ./src/app/error-page/error-page.component.css ***!
    \*****************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = ".container {\n  background-color: #F7F8F9;\n}\n"

    /***/
  }),

  /***/ "./src/app/error-page/error-page.component.html":
  /*!******************************************************!*\
    !*** ./src/app/error-page/error-page.component.html ***!
    \******************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = "<div class=\"container\">\n  <img src=\"../../assets/404_page.png\"/>\n</div>\n"

    /***/
  }),

  /***/ "./src/app/error-page/error-page.component.ts":
  /*!****************************************************!*\
    !*** ./src/app/error-page/error-page.component.ts ***!
    \****************************************************/
  /*! exports provided: ErrorPageComponent */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "ErrorPageComponent", function () {
      return ErrorPageComponent;
    });
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (undefined && undefined.__metadata) || function (k, v) {
      if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };

    var ErrorPageComponent = /** @class */ (function () {
      function ErrorPageComponent() {
      }

      ErrorPageComponent.prototype.ngOnInit = function () {
      };
      ErrorPageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
          selector: 'bs-error-page',
          template: __webpack_require__(/*! ./error-page.component.html */ "./src/app/error-page/error-page.component.html"),
          styles: [__webpack_require__(/*! ./error-page.component.css */ "./src/app/error-page/error-page.component.css")]
        }),
        __metadata("design:paramtypes", [])
      ], ErrorPageComponent);
      return ErrorPageComponent;
    }());


    /***/
  }),

  /***/ "./src/app/home-page/home-page.component.css":
  /*!***************************************************!*\
    !*** ./src/app/home-page/home-page.component.css ***!
    \***************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = ""

    /***/
  }),

  /***/ "./src/app/home-page/home-page.component.html":
  /*!****************************************************!*\
    !*** ./src/app/home-page/home-page.component.html ***!
    \****************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = "<h1>Welcome to the Bank of Karabroxos</h1>\n\n<p>\n  The Bank of Karabraxos is a financial institution used by the ultra-wealthy of the galaxy. It is the most secure bank in the galaxy: no one stepped foot on the planet without protocols, all movement is monitored, air consumption was regulated and DNA is required at every stage. Therefore, extremely valuable items are stored in the bank as well.\n</p>\n\n<a href=\"http://tardis.wikia.com/wiki/Bank_of_Karabraxos\" target=\"_blank\">Tardis Wiki Page</a>\n\n"

    /***/
  }),

  /***/ "./src/app/home-page/home-page.component.ts":
  /*!**************************************************!*\
    !*** ./src/app/home-page/home-page.component.ts ***!
    \**************************************************/
  /*! exports provided: HomePageComponent */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "HomePageComponent", function () {
      return HomePageComponent;
    });
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (undefined && undefined.__metadata) || function (k, v) {
      if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };

    var HomePageComponent = /** @class */ (function () {
      function HomePageComponent() {
      }

      HomePageComponent.prototype.ngOnInit = function () {
      };
      HomePageComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
          selector: 'bs-home-page',
          template: __webpack_require__(/*! ./home-page.component.html */ "./src/app/home-page/home-page.component.html"),
          styles: [__webpack_require__(/*! ./home-page.component.css */ "./src/app/home-page/home-page.component.css")]
        }),
        __metadata("design:paramtypes", [])
      ], HomePageComponent);
      return HomePageComponent;
    }());


    /***/
  }),

  /***/ "./src/app/navigation/navigation.component.css":
  /*!*****************************************************!*\
    !*** ./src/app/navigation/navigation.component.css ***!
    \*****************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = ".sidenav-container {\n  height: 100%;\n}\n\n.sidenav {\n  width: 200px;\n}\n\n.mat-toolbar.mat-primary {\n  position: -webkit-sticky;\n  position: sticky;\n  top: 0;\n}\n"

    /***/
  }),

  /***/ "./src/app/navigation/navigation.component.html":
  /*!******************************************************!*\
    !*** ./src/app/navigation/navigation.component.html ***!
    \******************************************************/
  /*! no static exports found */
  /***/ (function (module, exports) {

    module.exports = "<mat-sidenav-container class=\"sidenav-container\">\n\n  <mat-sidenav\n    #drawer\n    class=\"sidenav\"\n    fixedInViewport=\"true\"\n    [attr.role]=\"(isHandset$ | async) ? 'dialog' : 'navigation'\"\n    [mode]=\"(isHandset$ | async) ? 'over' : 'side'\"\n    [opened]=\"!(isHandset$ | async)\">\n    <mat-toolbar color=\"primary\">Menu</mat-toolbar>\n    <mat-nav-list>\n      <a mat-list-item href=\"\">Home</a>\n      <a mat-list-item href=\"currency\">Currency</a>\n    </mat-nav-list>\n  </mat-sidenav>\n\n  <mat-sidenav-content>\n    <div>\n    <mat-toolbar color=\"primary\">\n      <button\n        type=\"button\"\n        aria-label=\"Toggle sidenav\"\n        mat-icon-button\n        (click)=\"drawer.toggle()\"\n        *ngIf=\"isHandset$ | async\">\n        <mat-icon aria-label=\"Side nav toggle icon\">menu</mat-icon>\n      </button>\n      <img src=\"../../assets/banner.jpg\">\n    </mat-toolbar>\n    </div>\n\n    <router-outlet></router-outlet>\n\n  </mat-sidenav-content>\n\n</mat-sidenav-container>\n"

    /***/
  }),

  /***/ "./src/app/navigation/navigation.component.ts":
  /*!****************************************************!*\
    !*** ./src/app/navigation/navigation.component.ts ***!
    \****************************************************/
  /*! exports provided: NavigationComponent */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "NavigationComponent", function () {
      return NavigationComponent;
    });
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    /* harmony import */
    var _angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/layout */ "./node_modules/@angular/cdk/esm5/layout.es5.js");
    /* harmony import */
    var rxjs_operators__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm5/operators/index.js");
    var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
      var c = arguments.length,
        r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
      if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
      else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
      return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (undefined && undefined.__metadata) || function (k, v) {
      if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };


    var NavigationComponent = /** @class */ (function () {
      function NavigationComponent(breakpointObserver) {
        this.breakpointObserver = breakpointObserver;
        this.isHandset$ = this.breakpointObserver.observe(_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["Breakpoints"].Handset)
          .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_2__["map"])(function (result) {
            return result.matches;
          }));
      }

      NavigationComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
          selector: 'bs-navigation',
          template: __webpack_require__(/*! ./navigation.component.html */ "./src/app/navigation/navigation.component.html"),
          styles: [__webpack_require__(/*! ./navigation.component.css */ "./src/app/navigation/navigation.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_cdk_layout__WEBPACK_IMPORTED_MODULE_1__["BreakpointObserver"]])
      ], NavigationComponent);
      return NavigationComponent;
    }());


    /***/
  }),

  /***/ "./src/environments/environment.ts":
  /*!*****************************************!*\
    !*** ./src/environments/environment.ts ***!
    \*****************************************/
  /*! exports provided: environment */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony export (binding) */
    __webpack_require__.d(__webpack_exports__, "environment", function () {
      return environment;
    });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
    var environment = {
      production: false
    };
    /*
     * For easier debugging in development mode, you can import the following file
     * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
     *
     * This import should be commented out in production mode because it will have a negative impact
     * on performance if an error is thrown.
     */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


    /***/
  }),

  /***/ "./src/main.ts":
  /*!*********************!*\
    !*** ./src/main.ts ***!
    \*********************/
  /*! no exports provided */
  /***/ (function (module, __webpack_exports__, __webpack_require__) {

    "use strict";
    __webpack_require__.r(__webpack_exports__);
    /* harmony import */
    var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
    /* harmony import */
    var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
    /* harmony import */
    var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
    /* harmony import */
    var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");


    if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
      Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
    }
    Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
      .catch(function (err) {
        return console.error(err);
      });


    /***/
  }),

  /***/ 0:
  /*!************************************************************************!*\
    !*** multi (webpack)-dev-server/client?http://0.0.0.0:0 ./src/main.ts ***!
    \************************************************************************/
  /*! no static exports found */
  /***/ (function (module, exports, __webpack_require__) {

    __webpack_require__(/*! /Users/qs/Documents/Java/ng-portfolio/ng-portfolio-web/node_modules/webpack-dev-server/client/index.js?http://0.0.0.0:0 */"./node_modules/webpack-dev-server/client/index.js?http://0.0.0.0:0");
    module.exports = __webpack_require__(/*! /Users/qs/Documents/Java/ng-portfolio/ng-portfolio-web/src/main.ts */"./src/main.ts");


    /***/
  })

}, [[0, "runtime", "vendor"]]]);
//# sourceMappingURL=main.js.map
