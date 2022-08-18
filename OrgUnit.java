public class OrgUnit extends OrgUnitConf{
    public String name;

    public OrgUnit(String name, Boolean has_fixed_membership_fee, Integer fixed_membership_fee_amount){
        super(has_fixed_membership_fee, fixed_membership_fee_amount);
        this.name = name;
    }

}
