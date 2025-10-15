import { Component } from "@angular/core";
import { TicketBooking } from "../../types/TicketBooking";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
    selector:'app-ticketbooking',
    templateUrl:'./ticketbooking.component.html',
    styleUrls:['./ticketbooking.component.scss']
})
export class TicketBookingComponent {
    ticketBooking:TicketBooking;
    ticketBookingForm:FormGroup;
    successMessage:string='';
    errorMessage:string='';
    constructor(private fb:FormBuilder){
        this.ticketBookingForm=this.fb.group({
            bookingId:['',[Validators.required]],
            email:['',[Validators.required,Validators.email]],
            matchId:['',[Validators.required]],
            numberOfTickets:['',[Validators.required,Validators.minLength(1)]],
        })
     }
     onSubmit(){
        if(this.ticketBookingForm.valid){
            this.ticketBooking={...this.ticketBookingForm.value} as TicketBooking;
            this.successMessage="Tickets booked successfully!"
            this.errorMessage='';
            //console.log('Form Data:',this.teamForm.value);
        }else{
            this.successMessage='';
            this.errorMessage='Please fill out all required fields correctly.';
        }
         }
         resetForm(){
            this.ticketBookingForm.reset({
                email:'',
                matchId:'',
                numberOfTickets:''
            });
            this.successMessage='';
            this.errorMessage='';
         }
        }


