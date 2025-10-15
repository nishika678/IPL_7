import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Match } from "../../types/Match";

@Component({
    selector:'app-match-create',
    templateUrl:'./matchcreate.component.html',
    styleUrls:['./matchcreate.component.scss']
})
export class MatchCreateComponent {
    match:Match;
    matchForm:FormGroup;
    successMessage:string='';
    errorMessage:string='';
    constructor(private fb:FormBuilder){
        this.matchForm=this.fb.group({
            matchId:['',[Validators.required]],
            firstTeamId:['',[Validators.required]],
            secondTeamId:['',[Validators.required]],
            matchDate:['',[Validators.required]],
            venue:['',[Validators.required]],
            result:['',[Validators.required]],
            status:['',[Validators.required]],
            winnerTeamId:['',[Validators.required]],
        })
     }
    
     onSubmit(){
        if(this.matchForm.valid){
            this.match={...this.matchForm.value} as Match;
            this.successMessage="Match created successfully!"
            this.errorMessage='';
            //console.log('Form Data:',this.teamForm.value);
        }else{
            this.successMessage='';
            this.errorMessage='Please fill out all required fields correctly.';
        }
         }
         resetForm(){
            this.matchForm.reset({
                firstTeamId:0,
                secondTeamId:0,
                matchDate:'',
                venue:'Mumbai',
                result:'',
                status:'',
                winnerTeamId:0
            });
            this.successMessage='';
            this.errorMessage='';
         }
        
}
