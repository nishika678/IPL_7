import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Vote } from "../../types/Vote";

@Component({
    selector:'app-vote',
    templateUrl:'./vote.component.html',
    styleUrls:['./vote.component.scss']
})
export class VoteComponent  {
    vote:Vote;
    voteForm:FormGroup;
    successMessage:string='';
    errorMessage:string='';
    constructor(private fb:FormBuilder){
        this.voteForm=this.fb.group({
            voteId:['',[Validators.required]],
            email:['',[Validators.required]],
            category:['',[Validators.required]],
            cricketerId:['',[Validators.required]],
            teamId:['',[Validators.required]]
        })
     }
     onSubmit(){
        if(this.voteForm.valid){
            this.vote={...this.voteForm.value} as Vote;
            this.successMessage="Vote submitted successfully!"
            this.errorMessage='';
            //console.log('Form Data:',this.teamForm.value);
        }else{
            this.successMessage='';
            this.errorMessage='Please fill out all required fields correctly.';
        }
         }
         resetForm(){
            this.voteForm.reset({
                email:'',
                category:'',
                cricketerId:0,
                teamId:0
            });
            this.successMessage='';
            this.errorMessage='';
         }
        }
        
  


