Guide

Dedian 10.2 Baster

image: debian-10.2.0-amd64-netinst.iso

user root:
$ su 
$ apt update
$ apt install sudo
$ apt install net-tools
$ apt install mc

$ sudo nano /etc/ssh/sshd_config: 
Port 22
PermitRootLogin yes
$ sudo service sshd restart
$ netstat -tulnp | grep ssh


$ sudo reboot
$ sudo poweroff
$ ssh -p 2200 <user>@127.0.0.1
$ sudo ifconfig

$ dhclient (grep ip address 198.168.xxx.xxx)
$ ip a

nano /etc/network/interfaces: 

allow-hotplug enp0s3
iface enp0s3 inet dhcp
auto enp0s8
iface enp0s8 inet static
address 192.168.xxx.xxx
gateway 192.168.1.1
netmask 255.255.255.0


VirtualBox 6.0.14



MongoDB:

$ docker-machine create -d generic --generic-ip-address=127.0.01 --generic-ssh-key $HOME/.ssh/id_rsa --generic-ssh-user <user> --generic-ssh-port 2200 <your machine name>

check if success: $ docker-machine env <your machine name>

connect: eval $(docker-machine env <your machine name>)

$ docker pull mongo:latest

$ docker-compose up


Java 8