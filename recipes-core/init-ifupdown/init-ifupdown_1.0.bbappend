FILESEXTRAPATHS_prepend := "${THISDIR}/init-ifupdown-1.0:"

SRC_URI_append_qemuarma9 = " file://qemuarma9/interfaces"

do_install_append_qemuarma9 () {
	install -m 0644 ${WORKDIR}/qemuarma9/interfaces ${D}${sysconfdir}/network/interfaces
}
