Guide

Debian 10.2 Buster

image: debian-10.2.0-amd64-netinst.iso

user root:
$ su 

'# apt update

'# apt install sudo

'# apt install net-tools

'# apt install mc

'# nano /etc/ssh/sshd_config:
 
Port 22

PermitRootLogin yes

$ sudo service sshd restart

check:
$ netstat -tulnp | grep ssh


$ sudo reboot

$ sudo poweroff

$ ssh -p 2200 'user'@127.0.0.1

$ sudo ifconfig

$ dhclient (grep ip address 198.168.xxx.xxx)

$ ip a

$ sudo nano /etc/network/interfaces: 

allow-hotplug enp0s3

'#iface enp0s3 inet dhcp 

auto enp0s8

iface enp0s8 inet static

address 192.168.xxx.xxx

gateway 192.168.1.1

netmask 255.255.255.0


VirtualBox 6.0.14

Settings->Network->Adapter1->Advanced->Port Forwarding->

| Name | Protocol | Host IP | Host Port | Guest IP | Guest Port|

| ssh  | TCP      |127.0.0.1| 2200      | 10.0.2.15| 22        |

|mongo | TCP      |127.0.0.1| 47017     | 0.0.0.0  | 27017     |


Settings->Network->Adapter2->Enable Network Adapter->Name->vboxname0


MongoDB:

$ docker-machine create -d generic --generic-ip-address=127.0.01 --generic-ssh-key $HOME/.ssh/id_rsa --generic-ssh-user 'user' --generic-ssh-port 2200 'your machine name'

check if success: $ eval $(docker-machine env 'your machine name')

connect inside your IDE: eval $(docker-machine env 'your machine name')
https://docs.docker.com/machine/drivers/generic/

$ docker pull mongo:latest

$ docker volume create --name=mongodb_data_volume

$ docker-compose up


Java 8