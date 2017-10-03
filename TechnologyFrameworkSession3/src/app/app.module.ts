import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { ProductService } from './products.service';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
