import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner inObj = new Scanner(System.in);
      ArrayList<OrgUnit> input = new ArrayList<>(Arrays.asList(
        new OrgUnit ("client", false, 0), 
        new OrgUnit ("division_a", false, 0), 
        new OrgUnit ("division_b", true, 35000), 
        new OrgUnit ("area_a", true, 45000), 
        new OrgUnit ("area_b", false, 0), 
        new OrgUnit ("area_c", true, 45000), 
        new OrgUnit ("area_d", false, 0), 
        new OrgUnit ("branch_b", false, 0), 
        new OrgUnit ("branch_c", false, 0), 
        new OrgUnit ("branch_e", false, 0), 
        new OrgUnit ("branch_f", false, 0), 
        new OrgUnit ("branch_g", false, 0), 
        new OrgUnit ("branch_h", false, 0), 
        new OrgUnit ("branch_i", false, 0), 
        new OrgUnit ("branch_j", false, 0), 
        new OrgUnit ("branch_k", true, 25000), 
        new OrgUnit ("branch_l", false, 0), 
        new OrgUnit ("branch_n", false, 0), 
        new OrgUnit ("branch_o", false, 0), 
        new OrgUnit ("branch_p", false, 0)
      ));
      for (int i=0; i < input.size(); i++){
        OrgUnit aux_unit = input.get(i);

        System.out.println("Insert rent_amount for " + aux_unit.name);
        Integer aux_rent_amount = inObj.nextInt();
        System.out.println("Insert rent_period for " + aux_unit.name + " (m/w)");
        String aux_rent_period = inObj.next();

      System.out.println(aux_unit.name + ": " + calculate_mebership_fee(aux_rent_amount, aux_rent_period, aux_unit));
      }
    }

    //cost of the week rent + VAT
    static Integer calculate_mebership_fee(Integer rent_amount, String rent_period, OrgUnit organization_unit){
      if (rent_period == "w")
        if (rent_amount < 25 || rent_amount > 2000){
          System.out.println("Rent amount`s outide the range");
          return null;
        }

      if (rent_period == "m")
        if (rent_amount < 110 || rent_amount > 8660){
          System.out.println("Rent amount`s outide the range");
          return null;
        }

      if(organization_unit.has_fixed_membership_fee)
        return organization_unit.fixed_membership_fee_amount;
    
      Integer calc = (int)(rent_amount*0.2);

      if (rent_amount < 120)
        calc = (int)(120*0.2);

      return calc;
    }
  }
  