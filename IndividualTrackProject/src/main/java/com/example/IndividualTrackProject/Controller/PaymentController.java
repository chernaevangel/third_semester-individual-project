package com.example.IndividualTrackProject.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

     //private final IPaymentService paymentService;

    //Create payment
    /*
    @CrossOrigin("http://localhost:3000")
    @PostMapping
    public ResponseEntity<Payment> createBooking(@RequestBody Payment payment){
        paymentService.createPayment(payment);
        return ResponseEntity.ok().build();
    } */

    //Get all payments
    /*@CrossOrigin("http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> payments=paymentService.getAllPayments();
        if (payments!=null){
            return ResponseEntity.ok().body(payments);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Get payment
    /*
    @CrossOrigin("http://localhost:3000")
    @GetMapping("{id}")
    public ResponseEntity<Payment> getBooking(@PathVariable(value = "id") Long id){
        Payment payment=paymentService.getPayment(id);
        if(payment!=null){
            return ResponseEntity.ok().body(payment);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
     */

}
