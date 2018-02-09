DESCRIPTION = "Microsoft Azure IoT SDKs and libraries for C"
AUTHOR = "Microsoft Corporation"
HOMEPAGE = "https://github.com/Azure/azure-iot-sdk-c"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4283671594edec4c13aeb073c219237a"

SRCREV = "4f5b1f4fcafba68a93f322a2c34bd4d064a93750"
SRC_URI = "gitsm://github.com/azure/azure-iot-sdk-c.git;protocol=https;branch=master"

PROVIDES += "azure-iot-sdk-c"
DEPENDS = "curl openssl util-linux"

inherit pkgconfig cmake

S = "${WORKDIR}/git"

FILES_${PN} = "\
    ${libdir}/*.so \
    ${libdir}/*.so* \
    ${libdir}/azure-iot-sdk-c/* \
    ${bindir} \
"

do_compile() {
    ${S}/build_all/linux/build.sh --no-logging --toolchain-file ${WORKDIR}/toolchain.cmake --install-path-prefix ${D}/usr/
}

do_install() {
    cd ${S}/cmake/iotsdk_linux
    oe_runmake install

    install -d ${D}${libdir}azure-iot-sdk-c
    install -d ${D}${bindir}
    install -m 0777 ${S}/cmake/iotsdk_linux/iothub_client/samples/iothub_client_sample_amqp_websockets/iothub_client_sample_amqp_websockets ${D}${bindir}
    install -m 0777 ${S}/iothub_client/tests/global_valgrind_suppression.supp ${D}${libdir}azure-iot-sdk-c/global_valgrind_suppression.supp
}
