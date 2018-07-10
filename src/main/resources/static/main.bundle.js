webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <img width=\"300\" alt=\"Angular Logo\" src=\"/assets/logo_huk.svg\">\n  <hr class=\"linehuk\">\n\n  <router-outlet></router-outlet>\n\n</div>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_material_button__ = __webpack_require__("../../../material/esm5/button.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_material_checkbox__ = __webpack_require__("../../../material/esm5/checkbox.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_material_icon__ = __webpack_require__("../../../material/esm5/icon.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__angular_material_input__ = __webpack_require__("../../../material/esm5/input.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11__final_final_component__ = __webpack_require__("../../../../../src/app/final/final.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__last_last_component__ = __webpack_require__("../../../../../src/app/last/last.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__price_price_component__ = __webpack_require__("../../../../../src/app/price/price.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_14__start_start_component__ = __webpack_require__("../../../../../src/app/start/start.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_15__srv_service__ = __webpack_require__("../../../../../src/app/srv.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
















var appRoutes = [
    { path: '', component: __WEBPACK_IMPORTED_MODULE_14__start_start_component__["a" /* StartComponent */] },
    { path: 'price', component: __WEBPACK_IMPORTED_MODULE_13__price_price_component__["a" /* PriceComponent */] },
    { path: 'last', component: __WEBPACK_IMPORTED_MODULE_12__last_last_component__["a" /* LastComponent */] },
    { path: 'final', component: __WEBPACK_IMPORTED_MODULE_11__final_final_component__["a" /* FinalComponent */] },
    { path: '**', component: __WEBPACK_IMPORTED_MODULE_14__start_start_component__["a" /* StartComponent */] }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["K" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_10__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_14__start_start_component__["a" /* StartComponent */],
                __WEBPACK_IMPORTED_MODULE_13__price_price_component__["a" /* PriceComponent */],
                __WEBPACK_IMPORTED_MODULE_12__last_last_component__["a" /* LastComponent */],
                __WEBPACK_IMPORTED_MODULE_11__final_final_component__["a" /* FinalComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_7__angular_platform_browser__["a" /* BrowserModule */], __WEBPACK_IMPORTED_MODULE_0__angular_common_http__["b" /* HttpClientModule */], __WEBPACK_IMPORTED_MODULE_3__angular_material_button__["a" /* MatButtonModule */], __WEBPACK_IMPORTED_MODULE_4__angular_material_checkbox__["a" /* MatCheckboxModule */], __WEBPACK_IMPORTED_MODULE_5__angular_material_icon__["a" /* MatIconModule */], __WEBPACK_IMPORTED_MODULE_9__angular_router__["c" /* RouterModule */].forRoot(appRoutes), __WEBPACK_IMPORTED_MODULE_6__angular_material_input__["a" /* MatInputModule */], __WEBPACK_IMPORTED_MODULE_8__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["c" /* FormsModule */]
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_15__srv_service__["a" /* SrvService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_10__app_component__["a" /* AppComponent */]],
            schemas: [__WEBPACK_IMPORTED_MODULE_1__angular_core__["j" /* CUSTOM_ELEMENTS_SCHEMA */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/final/final.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/final/final.component.html":
/***/ (function(module, exports) {

module.exports = "<p>\n  Bestellung übermittelt. Sie erhalten demnächst ein Bestätigungsschreiben.\n</p>\n"

/***/ }),

/***/ "../../../../../src/app/final/final.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FinalComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var FinalComponent = /** @class */ (function () {
    function FinalComponent() {
    }
    FinalComponent.prototype.ngOnInit = function () {
    };
    FinalComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-final',
            template: __webpack_require__("../../../../../src/app/final/final.component.html"),
            styles: [__webpack_require__("../../../../../src/app/final/final.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], FinalComponent);
    return FinalComponent;
}());



/***/ }),

/***/ "../../../../../src/app/last/last.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".full-width {\r\n    width: 100%;\r\n  }", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/last/last.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Persönliche Daten</h2>\r\n<h5>aus dem Fahrzeugschein</h5>\r\n<mat-form-field class=\"full-width\">\r\n    <input matInput placeholder=\"Name\" [(value)]=\"s.name\">\r\n</mat-form-field>\r\n<mat-form-field class=\"full-width\">\r\n    <input matInput placeholder=\"Strasse\" [(value)]=\"s.strasse\">\r\n</mat-form-field>\r\n<mat-form-field class=\"full-width\">\r\n    <input matInput placeholder=\"PLZ\" [(value)]=\"s.plz\">\r\n</mat-form-field>\r\n<mat-form-field class=\"full-width\">\r\n    <input matInput placeholder=\"Ort\" [(value)]=\"s.ort\">\r\n</mat-form-field>\r\n<div class=\"height:30px;\"></div>\r\n<button mat-raised-button color=\"primary\" [routerLink]=\"['/final']\"  class=\"btn\">Bestellen</button>"

/***/ }),

/***/ "../../../../../src/app/last/last.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LastComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__srv_service__ = __webpack_require__("../../../../../src/app/srv.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var LastComponent = /** @class */ (function () {
    function LastComponent(s) {
        this.s = s;
    }
    LastComponent.prototype.ngOnInit = function () {
    };
    LastComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-last',
            template: __webpack_require__("../../../../../src/app/last/last.component.html"),
            styles: [__webpack_require__("../../../../../src/app/last/last.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__srv_service__["a" /* SrvService */]])
    ], LastComponent);
    return LastComponent;
}());



/***/ }),

/***/ "../../../../../src/app/price/price.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".btn{\r\n    padding-left: 30px;\r\n    padding-right: 30px;\r\n}\r\n\r\ntable{\r\n    width: 100%;\r\n    font-size: 1.2em;\r\n}\r\n\r\ntable tr td:nth-child(1){\r\n    text-align: left;\r\n}\r\n\r\ntable  tr td:nth-child(2){\r\n    text-align: right;\r\n}\r\n\r\n.lastRow{\r\n    border-top:1pt double black;\r\n    padding-top: 10px;\r\n    margin-top: 10px;\r\n    font-weight: bold;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/price/price.component.html":
/***/ (function(module, exports) {

module.exports = "<h2>Ihr Fahrzeug</h2>\n<h5>aus dem Fahrzeugschein</h5>\n<table>\n  <tr>\n    <td>Hersteller:</td>\n    <td>{{s.hersteller}}</td>\n  </tr>\n  <tr>\n    <td>Typ:</td>\n    <td>{{s.typ}}</td>  \n  </tr>\n  <tr>\n    <td>Leistung:</td>\n    <td>{{s.leistung}}PS</td>  \n  </tr>\n</table>\n<h2>Ihr Angebot</h2>\n<table>\n  <tr>\n    <td><mat-checkbox [checked]='s.haftpflichtChecked'  (change)=\"haftpflichtChanged($event)\" ><label>Haftpflicht</label></mat-checkbox></td>\n    <td>{{s.haftpflicht}}€ / Jahr</td>\n  </tr>\n  <tr>\n    <td><mat-checkbox [checked]='s.vollkaskoChecked' (change)=\"vollkaskoChanged($event)\"><label>Vollkasko</label></mat-checkbox></td>\n    <td>{{s.vollkasko}}€ / Jahr</td>  \n  </tr>\n  <tr>\n    <td><mat-checkbox [checked]='s.teilkaskoChecked'  (change)=\"teilkaskoChanged($event)\"><label>Teilkasko</label></mat-checkbox></td>\n    <td>{{s.teilkasko}}€ / Jahr</td>  \n  </tr>\n\n  <tr class=\"lastRow\">\n    <td class=\"lastRow\">Gesamt</td>\n    <td class=\"lastRow\">{{s.fullprice}}€ / Jahr</td>  \n  </tr>\n\n  \n</table>\n<div style=\"height:50px;\"></div>\n<button mat-raised-button color=\"primary\" [routerLink]=\"['/start']\" class=\"btn\">Back</button>\n<button mat-raised-button color=\"primary\" [routerLink]=\"['/last']\" (disabled)=\"btnDisabled\" class=\"btn\">Persönliche Daten</button>"

/***/ }),

/***/ "../../../../../src/app/price/price.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PriceComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__srv_service__ = __webpack_require__("../../../../../src/app/srv.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var PriceComponent = /** @class */ (function () {
    function PriceComponent(s) {
        this.s = s;
    }
    PriceComponent.prototype.ngOnInit = function () {
    };
    PriceComponent.prototype.haftpflichtChanged = function (ev) {
        this.s.haftpflichtChecked = !this.s.haftpflichtChecked;
        this.calculate(ev);
    };
    PriceComponent.prototype.teilkaskoChanged = function (ev) {
        this.s.teilkaskoChecked = !this.s.teilkaskoChecked;
        this.calculate(ev);
    };
    PriceComponent.prototype.vollkaskoChanged = function (ev) {
        this.s.vollkaskoChecked = !this.s.vollkaskoChecked;
        this.calculate(ev);
    };
    Object.defineProperty(PriceComponent.prototype, "btnDisabled", {
        get: function () {
            return this.s.fullprice <= 0;
        },
        enumerable: true,
        configurable: true
    });
    PriceComponent.prototype.calculate = function (ev) {
        var price = 0;
        if (this.s.haftpflichtChecked === true) {
            price = price + this.s.haftpflicht;
        }
        if (this.s.teilkaskoChecked === true) {
            price = price + this.s.teilkasko;
        }
        if (this.s.vollkaskoChecked === true) {
            price = price + this.s.vollkasko;
        }
        this.s.fullprice = price;
    };
    PriceComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-price',
            template: __webpack_require__("../../../../../src/app/price/price.component.html"),
            styles: [__webpack_require__("../../../../../src/app/price/price.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__srv_service__["a" /* SrvService */]])
    ], PriceComponent);
    return PriceComponent;
}());



/***/ }),

/***/ "../../../../../src/app/srv.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return SrvService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var httpOptions = {
    headers: new __WEBPACK_IMPORTED_MODULE_0__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' })
};
var SrvService = /** @class */ (function () {
    function SrvService(http, router) {
        this.http = http;
        this.router = router;
        this.name = '';
        this.plz = '';
        this.ort = '';
        this.strasse = '';
        this.fullprice = 0;
        this.haftpflicht = 0;
        this.teilkasko = 0;
        this.vollkasko = 0;
        this.typ = '';
        this.hersteller = '';
        this.leistung = 0;
        this.haftpflichtChecked = false;
        this.teilkaskoChecked = false;
        this.vollkaskoChecked = false;
        this.loading = false;
    }
    // Uses http.get() to load data from a single API endpoint
    SrvService.prototype.get = function (picture) {
        var _this = this;
        console.log('picture', picture);
        this.loading = true;
        return this.http.post('https://smart-car-insurance-backend.herokuapp.com/api/insurance', { picture: picture }).subscribe(function (data) {
            _this.addData(data);
            _this.router.navigate(['/price']);
            _this.loading = false;
        }, function (err) {
            console.error(err);
            _this.loading = false;
        }, function () {
            console.log('done loading');
            _this.loading = false;
        });
    };
    SrvService.prototype.addData = function (data) {
        this.name = data.name;
        this.ort = data.stadt;
        this.strasse = data.strasse;
        this.plz = data.plz;
        this.hersteller = data.hersteller;
        this.typ = data.typ;
        this.leistung = data.leistung;
        this.haftpflicht = data.haftpflicht;
        this.vollkasko = data.vollkasko;
        this.teilkasko = data.teilkasko;
    };
    SrvService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["C" /* Injectable */])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_0__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_2__angular_router__["b" /* Router */]])
    ], SrvService);
    return SrvService;
}());



/***/ }),

/***/ "../../../../../src/app/start/start.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/start/start.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>SCI App</h1>\n\n<div style=\"height:30px;\"></div>\n<label for=\"picture\">Fahrzeugschein wählen</label>\n\n<div style=\"height:10px;\"></div>\n<input class=\"mat-raised-button mat-accent\" type=\"file\" id=\"picture\" (change)=\"onFileChange($event)\" #fileInput accept=\"image/*\">\n  \n<div style=\"height:30px;\"></div>\n<button mat-raised-button color=\"accent\" [disabled]=\"!picture\" (click)=\"onSubmit()\">Hochladen und Beitrag berechnen</button>\n<div style=\"height:30px;\"></div>\n<img src=\"/assets/loader.gif\" *ngIf=\"s.loading\" />"

/***/ }),

/***/ "../../../../../src/app/start/start.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return StartComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__srv_service__ = __webpack_require__("../../../../../src/app/srv.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var StartComponent = /** @class */ (function () {
    function StartComponent(s, route) {
        this.s = s;
        this.route = route;
        //  form: FormGroup;
        this.loading = false;
    }
    StartComponent.prototype.ngOnInit = function () { };
    StartComponent.prototype.onFileChange = function (event) {
        var _this = this;
        var reader = new FileReader();
        if (event.target.files && event.target.files.length > 0) {
            var file = event.target.files[0];
            reader.readAsDataURL(file);
            reader.onload = function () {
                var data = reader.result.split(',');
                console.log('File');
                _this.picture = data[1];
            };
        }
    };
    StartComponent.prototype.onSubmit = function () {
        this.s.get(this.picture);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_11" /* ViewChild */])('fileInput'),
        __metadata("design:type", __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */])
    ], StartComponent.prototype, "fileInput", void 0);
    StartComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
            selector: 'app-start',
            template: __webpack_require__("../../../../../src/app/start/start.component.html"),
            styles: [__webpack_require__("../../../../../src/app/start/start.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_2__srv_service__["a" /* SrvService */], __WEBPACK_IMPORTED_MODULE_1__angular_router__["a" /* ActivatedRoute */]])
    ], StartComponent);
    return StartComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map