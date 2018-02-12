LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "e2fsprogs e2fsprogs-resize2fs"
IMAGE_INSTALL += "valgrind curl azure-iot-sdk-c"

IMAGE_FSTYPES = "ext4.gz ext4"

SDKIMAGE_FEATURES = "dev-pkgs dbg-pkgs staticdev-pkgs"
