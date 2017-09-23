package nl.hu.curcon.dto;

import java.util.List;

/**
 * Created by jayfeurich on 25/06/15.
 */
public class BeroepsProductDto extends BeoordelingsElementDto {

    private List<String[]> criterialinks;

    public List<String[]> getCriterialinks() {
        return criterialinks;
    }

    public void setCriterialinks(List<String[]> criterialinks) {
        this.criterialinks = criterialinks;
    }
}
