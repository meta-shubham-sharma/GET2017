import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';

// Imports for loading & configuring the in-memory web api
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './in-memory-data.service';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard.component';
import { ProductsComponent } from './products.component';
import { ProductDetailComponent } from './product-detail.component';
import { ProductService } from './product.service';
import { ProductSearchComponent } from './product-search.component';
import { ContactUsComponent } from './contact-us.component';
import { AddProductComponent } from './add-product.component';
import { GetProductDetailComponent } from './get-product-detail.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService),
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    DashboardComponent,
    ProductDetailComponent,
    ProductsComponent,
    ProductSearchComponent,
    ContactUsComponent,
    AddProductComponent,
    GetProductDetailComponent
  ],
  providers: [ ProductService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
