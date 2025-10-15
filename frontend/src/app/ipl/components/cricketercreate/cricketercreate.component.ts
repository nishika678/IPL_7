import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Cricketer } from "../../types/Cricketer";

@Component({
    selector:'app-cricketercreate',
    templateUrl:'./cricketercreate.component.html',
    styleUrls:['./cricketercreate.component.scss']
})
export class CricketerCreateComponent {
    cricketer:Cricketer;
    cricketerForm:FormGroup;
    successMessage:string='';
    errorMessage:string='';
    constructor(private fb:FormBuilder){
        this.cricketerForm=this.fb.group({
            cricketerId:['',[Validators.required]],
            teamId:['',[Validators.required]],
            cricketerName:['',[Validators.required]],
            age:['',[Validators.required]],
            nationality:['',[Validators.required]],
            experience:['',[Validators.required]],
            role:['',[Validators.required]],
            totalRuns:['',[Validators.required]],
            totalWickets:['',[Validators.required]]
        })
     }
     onSubmit(){
        if(this.cricketerForm.valid){
            this.cricketer={...this.cricketerForm.value} as Cricketer;
            this.successMessage="Cricketer created successfully!"
            this.errorMessage='';
            //console.log('Form Data:',this.teamForm.value);
        }else{
            this.successMessage='';
            this.errorMessage='Please fill out all required fields correctly.';
        }
         }
         resetForm(){
            this.cricketerForm.reset({
    cricketerName:'',
    age:18,
    nationality:'',
    experience:'',
    role:'',
    totalRuns:0,
    totalWickets:0,
            });
            this.successMessage='';
            this.errorMessage='';
         }
           
}