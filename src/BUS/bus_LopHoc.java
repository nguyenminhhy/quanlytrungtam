/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_LopHoc;
import DTO.dto_LopHoc;
import java.util.ArrayList;

/**
 *
 * @author ThinkPro
 */
public class bus_LopHoc {

    public ArrayList<dto_LopHoc> layDsLop(int trangThai) {

        return new dal_LopHoc().layDsLop(trangThai);
    }
}
