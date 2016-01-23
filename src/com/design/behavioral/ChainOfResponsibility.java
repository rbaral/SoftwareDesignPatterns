/**
 * This is the illustration of chain of responsibility design pattern
 * ref:https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern
 */
package com.design.behavioral;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * this class represents the purchasing request
 * that is presented to an employee, who needs to decide on it
 * @modified rbaral
 *
 */
class PurchaseRequest {
    private double amount;
    private String purpose;

    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amt)  {
        amount = amt;
    }

    public String getPurpose() {
        return purpose;
    }
    public void setPurpose(String reason) {
        purpose = reason;
    }
}

/**
 * an abstract class with basic methods for
 * the objects in the chain
 * @modified rbaral
 *
 */
abstract class PurchasePower {
    protected static final double BASE = 500;
    protected PurchasePower successor;

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    abstract public void processRequest(PurchaseRequest request);
}

/**
 * class representing one of the object/handler
 * in the the chain
 * @modified rbaral
 *
 */
class ManagerPPower extends PurchasePower {
    private final double ALLOWABLE = 10 * BASE;

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Manager will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

/**
 * class representing one of the object/handler
 * in the the chain
 * @modified rbaral
 *
 */
class DirectorPPower extends PurchasePower {
    private final double ALLOWABLE = 20 * BASE;

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Director will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

/**
 * class representing one of the object/handler
 * in the the chain
 * @modified rbaral
 *
 */
class VicePresidentPPower extends PurchasePower {
    private final double ALLOWABLE = 40 * BASE;

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("Vice President will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        }
    }
}

/**
 * class representing one of the object/handler
 * in the the chain. As there is no successor of this
 * handler, it also handles the default action.
 * @modified rbaral
 *
 */
class PresidentPPower extends PurchasePower {
    private final double ALLOWABLE = 60 * BASE;

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < ALLOWABLE) {
            System.out.println("President will approve $" + request.getAmount());
        } else {
            System.out.println( "Your request for $" + request.getAmount() + " needs a board meeting!");
        }
    }
}

/**
 * this is the client module in the chain of responsibility
 * design pattern
 * @modified rbaral
 *
 */
class ChainOfResponsibility {
    public static void main(String[] args) {
        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);

        // Press Ctrl+C to end.
        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your expenditure.");
                System.out.print(">");
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.processRequest(new PurchaseRequest(d, "General"));
           }
        } catch(Exception e) {
        	System.err.println("Exception occured:"+e.getMessage());
        }
    }
}

