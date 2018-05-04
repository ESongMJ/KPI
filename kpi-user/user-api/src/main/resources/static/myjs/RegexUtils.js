/**
 * 根据传入的format匹配对应的日期
 * 匹配上了返回true 反之 返回false
 *
 * @param format
 * @param value
 * @returns {boolean}
 */
function checkDate(format, value) {
    var dateRegex = /^\d{4}-(0[1-9]|1[0-2])-((0[1-9])|(([12])[0-9])|3[0-1])$/;
    var timeRegex = /^(([01][0-9])|2[0-3]):([0-5][0-9]):([0-5][0-9])$/;
    var dateTimeRegex = /^\d{4}-(0[1-9]|1[0-2])-((0[1-9])|(([12])[0-9])|3[0-1]) (([01][0-9])|2[0-3]):([0-5][0-9]):([0-5][0-9])$/;
    if (format === "yyyy-MM-dd") {
        return dateRegex.test(value);
    }
    if (format === "HH:mm:ss") {
        return timeRegex.test(value);
    }
    if (format === "yyyy-MM-dd HH:mm:ss") {
        return dateTimeRegex.test(value);
    }
}
function checkNumber(value) {
    var numberRegex = /^[0-9]*$/;
    return numberRegex.test(value);
}
function checkPhone(value) {
    var phoneRegex = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d)|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d))$)/;

    return phoneRegex.test(value);
}