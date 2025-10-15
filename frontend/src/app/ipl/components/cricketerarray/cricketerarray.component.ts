import { Component, OnInit } from "@angular/core";
import { Cricketer } from "../../types/Cricketer";

@Component({
    selector:'app-cricketer-array',
    templateUrl:'./cricketerarray.component.html',
    styleUrls:['./cricketerarray.component.scss']
})
export class CricketerArrayComponent  implements OnInit{
    cricketers:Cricketer[]=[];
    showCricketers:boolean=false;
    ngOnInit(): void {
        this.cricketers= [
            new Cricketer(1,101,"Virat Kohli", 35, "Indian",17,"Batsman",18000, 25),
            new Cricketer(2,102,'AB de Villiers',31,'Indian',10,'Bowler',500,250),
            new Cricketer(3,103,'Ben Stokes',34,'English',12,'All-rounder',7500,150),
            new Cricketer(4,104,'Steve Smith',36,'Australian',14,'Batsman',9500,30)
        ];
    }
    
 toggleCricketers(){
    this.showCricketers=!this.showCricketers;
 }

}
