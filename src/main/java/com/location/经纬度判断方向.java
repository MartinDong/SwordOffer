package com.location;

import static java.lang.Math.PI;

public class 经纬度判断方向 {

    /**
     * 计算车辆行驶方向 与 poi点到车辆的连线 间的夹角
     *
     * @param carLon   车辆位置 lon
     * @param carLat   车辆位置 lat
     * @param poiLon   poi 位置 lon
     * @param poiLat   poi 位置 lat
     * @param carAngle 车辆行驶方向
     * @return
     */
    public static int getDegreeOfCar2Poi(double carLon, double carLat, double poiLon, double poiLat, int carAngle) {
        int poiAngle = 0;
        // 以子午线作为y轴 计算两点的余切 再将余切值转化为角度
        double _angle = Math.atan2(Math.abs(carLon - poiLon), Math.abs(carLat - poiLat)) * (180 / PI);
        //Log.w(MODULE_NAME, "getDegreeOfCar2Poi_计算车辆行驶方向 与 poi点到车辆的连线 间的夹角_angle===" + _angle);
        if (poiLon > carLon) {
            // poi 在 车辆位置的第1象限
            if (poiLat > carLat) {
                poiAngle = (int) _angle;
            }
            // poi 在 车辆位置的第2象限
            else {
                poiAngle = 180 - (int) _angle;
            }
        } else {
            // poi 在 车辆位置的第3象限
            if (poiLat < carLat) {
                poiAngle = (int) _angle + 180;
            }
            // poi 在 车辆位置的第4象限
            else {
                poiAngle = 360 - (int) _angle;
            }
        }
        return calculationAngle(poiAngle, carAngle);
    }

    /**
     * 计算两个行驶方向间的夹角 计算结果小于180度
     *
     * @param angle0
     * @param angle1
     * @return
     */
    public static int calculationAngle(int angle0, int angle1) {
        // 获取两方向间夹角
        int angle = Math.abs(angle0 - angle1);
        if (angle > 180) {
            int minAngle = Math.min(angle0, angle1);
            int maxAngle = Math.max(angle0, angle1);
            return 180 - Math.abs(minAngle + 180 - maxAngle);
        } else {
            return angle;
        }
    }


    /**
     * 计算连两个角度差值
     *
     * @param angle1 角度1
     * @param angle2 角度2
     * @return 差值
     */
    public static double getAngleDiff(double angle1, double angle2) {
        // 两个角度差值较小
        return 180 - Math.abs(Math.abs(angle1 - angle2) - 180);
    }

    public static void main(String[] args) {
        System.out.println("经纬度判断方向");

        int angleDif = getDegreeOfCar2Poi(
                116.42333239997701,39.983447316068045,
                116.423016,39.983405,
                89
        );

        System.out.println("angleDif=" +  angleDif);
//        System.out.println("calculationAngle=" +  calculationAngle(angleDif, 89));
//        System.out.println("getAngleDiff=" +  getAngleDiff(angleDif, 89));


    }
}
