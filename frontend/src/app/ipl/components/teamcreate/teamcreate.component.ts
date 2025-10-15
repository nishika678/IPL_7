import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector:'app-team-create',
    templateUrl:'./teamcreate.component.html',
    styleUrls:['./teamcreate.component.scss']
})
export class TeamCreateComponent {
 teamForm:FormGroup;
 successM:string='';
 errorM:string='';
 teamName:'';
 location:'';
 OwnerName:'';
 establishmentYear:2025;
 constructor(private fb:FormBuilder){
    this.teamForm=this.fb.group({
        teamId:['',[Validators.required]],
        teamName:['',[Validators.required]],
        location:['',[Validators.required]],
        ownerName:['',[Validators.required]],
        establishmentYear:['',[Validators.required]]

    })
 }
 onSubmit(){
if(this.teamForm.valid){
    this.successM="Team has been successfully created!"
    this.errorM='';
    //console.log('Form Data:',this.teamForm.value);
}else{
    this.successM='';
    this.errorM='Please fill out all required fields correctly.';
}
 }
 resetForm(){
    this.teamForm.reset({
        // id:null,
        teamName:'',
        location:'',
        ownerName:'',
        establishmentYear:2025
    });
    this.successM='';
    this.errorM='';
 }
}
